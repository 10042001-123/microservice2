package com.naveen.stock_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stock_price")
public class StockPrice {
	
	@Id
	@Column(name="stock_id")
	private Integer stockId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_price")
	private double companyPrice;

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getCompanyPrice() {
		return companyPrice;
	}

	public void setCompanyPrice(double companyPrice) {
		this.companyPrice = companyPrice;
	}
	
	

}
