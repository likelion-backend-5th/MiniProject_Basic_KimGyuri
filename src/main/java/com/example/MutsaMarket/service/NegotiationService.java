package com.example.MutsaMarket.service;

import com.example.MutsaMarket.dto.ProposalDto;
import com.example.MutsaMarket.dto.ProposalListDto;
import com.example.MutsaMarket.dto.UpdateProposalDto;
import com.example.MutsaMarket.entity.NegotiationEntity;
import com.example.MutsaMarket.entity.SalesItemEntity;
import com.example.MutsaMarket.repository.NegotiationRepository;
import com.example.MutsaMarket.repository.SalesItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    //구매 제안 조회
    public Page<ProposalListDto> readProposalAll(Long itemId, String writer, String password, Integer page) {
        Optional<SalesItemEntity> optionalSalesItem = salesItemRepository.findById(itemId);
        List<NegotiationEntity> optionalNegotiation = negotiationRepository.findByItemId(itemId);

        //대상 물품이 없을 때
        if (optionalSalesItem.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        //물품 등록자의 경우
        SalesItemEntity item = optionalSalesItem.get();
        if(item.getWriter().equals(writer) && item.getPassword().equals(password)) {
            Pageable pageable = PageRequest.of(page, 25, Sort.by("id"));
            Page<NegotiationEntity> proposalEntityPage = negotiationRepository.findAllByItemId(itemId, pageable);
            return proposalEntityPage.map(ProposalListDto::fromEntity);
        }

        //구매 제안자의 경우
        else if(!optionalNegotiation.isEmpty()) {
            Pageable pageable = PageRequest.of(page, 25, Sort.by("id"));
            Page<NegotiationEntity> proposalEntityPage = negotiationRepository.findAllByItemIdAndWriterAndPassword(itemId, writer, password, pageable);
            return proposalEntityPage.map(ProposalListDto::fromEntity);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //구매 제안 수정
    public boolean updateProposal(Long itemId, Long proposalId, UpdateProposalDto dto) {
        Optional<NegotiationEntity> optionalProposal = negotiationRepository.findById(proposalId);
        if (optionalProposal.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        Optional<SalesItemEntity> optionalSalesItem = salesItemRepository.findById(itemId);
        if (optionalSalesItem.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        NegotiationEntity proposal = optionalProposal.get();
        SalesItemEntity item = optionalSalesItem.get();

        //구매 제안자
        if(proposal.getItemId().equals(itemId) && proposal.getWriter().equals(dto.getWriter()) && proposal.getPassword().equals(dto.getPassword())) {
            proposal.setSuggestedPrice(dto.getSuggestedPrice());
            negotiationRepository.save(proposal);
            return true;
        }

        //물품 등록자
        else if(proposal.getItemId().equals(itemId) && item.getWriter().equals(dto.getWriter()) && item.getPassword().equals(dto.getPassword())) {
            proposal.setStatus(dto.getStatus());
            negotiationRepository.save(proposal);
            return false;
        }

        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //구매 제안 삭제
    public void deleteProposal(Long itemId, Long proposalId, UpdateProposalDto dto) {
        Optional<NegotiationEntity> optionalProposal = negotiationRepository.findById(proposalId);
        if (optionalProposal.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        NegotiationEntity proposal = optionalProposal.get();
        if(proposal.getItemId().equals(itemId) || proposal.getItemId().equals(proposalId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        if(proposal.getWriter().equals(dto.getWriter()) && proposal.getPassword().equals(dto.getPassword()))
            negotiationRepository.deleteById(proposalId);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
