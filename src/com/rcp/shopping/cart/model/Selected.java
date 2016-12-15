package com.rcp.shopping.cart.model;

public class Selected {
	
	private Product product;
	private int count;
	private double total;
	private String promoCode;

	public Selected(Product product, int count){
		this.product = product;
		this.count = count;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getPromoCode(){
		return promoCode;
	}
	
	public void setPromoCode(String promoCode){
		this.promoCode = promoCode;
	}
}
