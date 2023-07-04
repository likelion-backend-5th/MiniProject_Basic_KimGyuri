package com.example.MutsaMarket.repository;

import com.example.MutsaMarket.entity.NegotiationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NegotiationRepository extends JpaRepository<NegotiationEntity, Long> {
    List<NegotiationEntity> findByItemId(Long itemId);
    Page<NegotiationEntity> findAllByItemIdAndWriterAndPassword(Long itemId, String writer, String password, Pageable pageable);
    Page<NegotiationEntity> findAllByItemId(Long itemId, Pageable pageable);
}
