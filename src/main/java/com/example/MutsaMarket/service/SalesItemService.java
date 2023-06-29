package com.example.MutsaMarket.service;

import com.example.MutsaMarket.dto.SalesItemDto;
import com.example.MutsaMarket.entity.SalesItemEntity;
import com.example.MutsaMarket.repository.SalesItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesItemService {
    private final SalesItemRepository repository;

    //물품 등록
    public SalesItemDto createItem(SalesItemDto dto) {
        SalesItemEntity newItem = new SalesItemEntity();
        newItem.setTitle(dto.getTitle());
        newItem.setDescription(dto.getDescription());
        newItem.setMinPriceWanted(dto.getMinPriceWanted());
        newItem.setWriter(dto.getWriter());
        newItem.setPassword(dto.getPassword());
        newItem.setStatus("판매중");
        return SalesItemDto.fromEntity(this.repository.save(newItem));
    }
}
