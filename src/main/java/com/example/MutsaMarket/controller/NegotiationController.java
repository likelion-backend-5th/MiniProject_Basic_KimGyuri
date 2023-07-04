package com.example.MutsaMarket.controller;

import com.example.MutsaMarket.dto.ProposalDto;
import com.example.MutsaMarket.dto.ProposalListDto;
import com.example.MutsaMarket.dto.UpdateProposalDto;
import com.example.MutsaMarket.service.NegotiationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/items/{itemId}")
@RequiredArgsConstructor
public class NegotiationController {
    private final NegotiationService service;

    //구매 제안 등록
    @PostMapping("/proposal")
    public ResponseEntity<Map<String, String>> create(@RequestBody ProposalDto dto, @PathVariable("itemId") Long itemId) {
        log.info(dto.toString());
        service.createProposal(itemId, dto);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "구매 제안이 등록되었습니다.");

        return ResponseEntity.ok(responseBody);
    }

    //구매 제안 조회
    @GetMapping
    public Page<ProposalListDto> readAll(@PathVariable("itemId") Long itemId, @RequestParam("writer") String writer, @RequestParam("password") String password, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return service.readProposalAll(itemId, writer, password, page);
    }

    //구매 제안 수정
    @PutMapping("/{proposalId}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("itemId") Long itemId, @PathVariable("proposalId") Long proposalId, @RequestBody UpdateProposalDto dto) {
        log.info(dto.toString());
        String result = service.updateProposal(itemId, proposalId, dto);
        Map<String, String> responseBody = new HashMap<>();

        if (result.equals("edit"))
            responseBody.put("message", "제안이 수정되었습니다.");
        if (result.equals("modify"))
            responseBody.put("message", "제안의 상태가 변경되었습니다.");
        if (result.equals("confirm"))
            responseBody.put("message", "구매가 확정되었습니다.");

        return ResponseEntity.ok(responseBody);
    }

    //구매 제안 삭제
    @DeleteMapping("{proposalId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("itemId") Long itemId, @PathVariable("proposalId") Long proposalId, @RequestBody UpdateProposalDto dto) {
        log.info(dto.toString());
        service.deleteProposal(itemId, proposalId, dto);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "제안을 삭제했습니다.");

        return ResponseEntity.ok(responseBody);
    }
}
