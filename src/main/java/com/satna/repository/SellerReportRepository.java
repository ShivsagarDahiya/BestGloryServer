package com.satna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satna.model.SellerReport;

public interface SellerReportRepository extends JpaRepository<SellerReport,Long> {
    SellerReport findBySellerId(Long sellerId);
}
