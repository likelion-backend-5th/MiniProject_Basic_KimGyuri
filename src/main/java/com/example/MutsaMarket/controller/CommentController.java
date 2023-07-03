package com.example.MutsaMarket.controller;

import com.example.MutsaMarket.dto.CommentDto;
import com.example.MutsaMarket.dto.CommentListDto;
import com.example.MutsaMarket.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/items/{itemId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    //댓글 작성
    @PostMapping
    public ResponseEntity<Map<String, String>> create(@PathVariable("itemId") Long itemId, @RequestBody CommentDto dto) {
        log.info(dto.toString());
        service.createComment(itemId, dto);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "댓글이 등록되었습니다.");

        return ResponseEntity.ok(responseBody);
    }

    //게시글 댓글 조회
    @GetMapping
    public Page<CommentListDto> readAll(@PathVariable("itemId") Long itemId) {
        return service.readCommentAll(itemId);
    }
}
