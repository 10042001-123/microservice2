package com.naveen.stock_service.service;

import com.naveen.stock_service.entity.StockPrice;

public interface IStockPriceService {

	public double fetchByCompanyName(String companyName);
}
