package ru.zhenyaak;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Results {
	private String productId;
	private String sellerId;
	private String oriMinPrice;
	private String oriMaxPrice;
	private String promotionId;
	private String startTime;
	private String endTime;
	private String phase;
	private String productTitle;
	private String minPrice;
	private String maxPrice;
	private String discount;
	private String totalStock;
	private String stock;
	private String orders;
	private String soldout;
	private String productImage;
	private String productDetailUrl;
	private String trace;
	private String totalTranpro3;
	private String productPositiveRate;
	private String productAverageStar;
	private String itemEvalTotalNum;
	private String gmtCreate;
	
	public Results() {
		
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public void setOriMinPrice(String oriMinPrice) {
		this.oriMinPrice = oriMinPrice;
	}

	public void setOriMaxPrice(String oriMaxPrice) {
		this.oriMaxPrice = oriMaxPrice;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setTotalStock(String totalStock) {
		this.totalStock = totalStock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public void setTotalTranpro3(String totalTranpro3) {
		this.totalTranpro3 = totalTranpro3;
	}

	public void setProductPositiveRate(String productPositiveRate) {
		this.productPositiveRate = productPositiveRate;
	}

	public void setProductAverageStar(String productAverageStar) {
		this.productAverageStar = productAverageStar;
	}

	public void setItemEvalTotalNum(String itemEvalTotalNum) {
		this.itemEvalTotalNum = itemEvalTotalNum;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return productId + ","
				+ sellerId + ","
				+ oriMinPrice + ","
				+ oriMaxPrice + ","
				+ promotionId + ","
				+ startTime + ","
				+ endTime + ","
				+ phase + ","
				+ productTitle + ","
				+ minPrice + ","
				+ maxPrice + ","
				+ discount + ","
				+ totalStock + ","
				+ stock + ","
				+ orders + ","
				+ soldout + ","
				+ productImage + ","
				+ productDetailUrl + ","
				+ trace + ","
				+ totalTranpro3 + ","
				+ productPositiveRate + ","
				+ productAverageStar + ","
				+ itemEvalTotalNum + ","
				+ gmtCreate;
	}
	
}

