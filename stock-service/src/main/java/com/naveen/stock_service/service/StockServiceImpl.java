package com.naveen.stock_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.stock_service.entity.StockPrice;
import com.naveen.stock_service.exception.StockNotFoundExcetion;
import com.naveen.stock_service.repo.StockRepo;

@Service
public class StockServiceImpl implements IStockPriceService {
	private static final Logger log=LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	StockRepo stockRepo;

	@Override
	public double fetchByCompanyName(String companyName) {
		log.info("user requested for fetchByCompanyName");

		StockPrice stockPrice=stockRepo.findByCompanyName(companyName);
		if(stockPrice == null) {
			throw new StockNotFoundExcetion("stock price is not available for the given company");
		}
		return stockPrice.getCompanyPrice();
	}

}
