package com.example.MutsaMarket.dto;

import com.example.MutsaMarket.entity.NegotiationEntity;
import lombok.Data;

@Data
public class UpdateProposalDto {
    private String writer;
    private String password;
    private Long suggestedPrice;
    private String status;

    public static UpdateProposalDto fromEntity(NegotiationEntity entity) {
        UpdateProposalDto dto = new UpdateProposalDto();
        dto.setWriter(entity.getWriter());
        dto.setPassword(entity.getPassword());
        dto.setSuggestedPrice(entity.getSuggestedPrice());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
