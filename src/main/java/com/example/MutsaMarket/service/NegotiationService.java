package com.example.MutsaMarket.service;

import com.example.MutsaMarket.dto.ProposalDto;
import com.example.MutsaMarket.entity.NegotiationEntity;
import com.example.MutsaMarket.repository.NegotiationRepository;
import com.example.MutsaMarket.repository.SalesItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NegotiationService {
    private final SalesItemRepository salesItemRepository;
    private final NegotiationRepository negotiationRepository;

    //구매 제안 등록
    public ProposalDto createProposal(Long itemId, ProposalDto dto) {
        NegotiationEntity newProposal = new NegotiationEntity();
        newProposal.setWriter(dto.getWriter());
        newProposal.setPassword(dto.getPassword());
        newProposal.setSuggestedPrice(dto.getSuggestedPrice());
        newProposal.setItemId(itemId);
        newProposal.setStatus("제안");
        newProposal = negotiationRepository.save(newProposal);
        return ProposalDto.fromEntity(newProposal);
    }
}
