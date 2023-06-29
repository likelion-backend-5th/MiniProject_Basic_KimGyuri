package com.example.MutsaMarket.service;

import com.example.MutsaMarket.dto.ItemListDto;
import com.example.MutsaMarket.dto.SalesItemDto;
import com.example.MutsaMarket.entity.SalesItemEntity;
import com.example.MutsaMarket.repository.SalesItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //물품 전체 조회
    public Page<ItemListDto> readItemAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id"));
        Page<SalesItemEntity> itemEntityPage = repository.findAll(pageable);
        Page<ItemListDto> itemListDtoPage = itemEntityPage.map(ItemListDto::fromEntity);
        return itemListDtoPage;
    }
}
