package com.example.MutsaMarket.service;

import com.example.MutsaMarket.dto.CommentDto;
import com.example.MutsaMarket.dto.CommentListDto;
import com.example.MutsaMarket.entity.CommentEntity;
import com.example.MutsaMarket.repository.CommentRepository;
import com.example.MutsaMarket.repository.SalesItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final SalesItemRepository salesItemRepository;
    private final CommentRepository commentRepository;

    //댓글 작성
    public CommentDto createComment(Long itemId, CommentDto dto) {
        if (!salesItemRepository.existsById(itemId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        CommentEntity newComment = new CommentEntity();
        newComment.setWriter(dto.getWriter());
        newComment.setPassword(dto.getPassword());
        newComment.setContent(dto.getContent());
        newComment.setItemId(itemId);
        newComment = commentRepository.save(newComment);
        return CommentDto.fromEntity(newComment);
    }

    //게시글 댓글 조회
    public Page<CommentListDto> readCommentAll(Long itemId) {
        Pageable pageable = PageRequest.of(0, 25, Sort.by("id"));
        Page<CommentEntity> commentEntityPage = commentRepository.findAll(pageable);
        Page<CommentListDto> commentListDtoPage = commentEntityPage.map(CommentListDto::fromEntity);
        return commentListDtoPage;
    }

    //게시글 댓글 수정
    public CommentDto updateComment(Long itemId, Long commentId, CommentDto dto) {
        Optional<CommentEntity> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        CommentEntity comment = optionalComment.get();
        if (!itemId.equals(comment.getItemId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (comment.getWriter().equals(dto.getWriter()) && comment.getPassword().equals(dto.getPassword())) {
            comment.setContent(dto.getContent());
            commentRepository.save(comment);
            return CommentDto.fromEntity(comment);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}

