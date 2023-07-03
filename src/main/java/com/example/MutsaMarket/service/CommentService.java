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
}

