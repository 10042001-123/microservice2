package com.naveen.stock_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.stock_service.entity.StockPrice;

public interface StockRepo extends JpaRepository<StockPrice,Integer> {
	public StockPrice findByCompanyName(String companyName);

}
