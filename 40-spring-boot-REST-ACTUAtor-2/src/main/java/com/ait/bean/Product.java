package com.ait.bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true) // ignore unknown values
@JsonInclude(JsonInclude.Include.NON_NULL) // ignore null fields
@JsonPropertyOrder({"id","name","price"})
public class Product {
	@JsonProperty("id") // custom json field
	private long productId;

	@JsonProperty("name")
	private String productName;

	@JsonIgnore // exclude this field from JSON
	private String secretCode;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date manufactureDate;

	@JsonProperty("coupens")
	private List<String> coupen;

	private double price;

	public Product(long productId, String productName, String secretCode, Date manufactureDate,
			List<String> coupen, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.secretCode = secretCode;
		this.manufactureDate = manufactureDate;
		this.coupen = coupen;
		this.price = price;
	}

	public Product() {

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", secretCode=" + secretCode
				+ ", manufactureDate=" + manufactureDate + ", price=" + price + "]";
	}
}
