package com.example.MutsaMarket.repository;

import com.example.MutsaMarket.entity.NegotiationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NegotiationRepository extends JpaRepository<NegotiationEntity, Long> {
}
