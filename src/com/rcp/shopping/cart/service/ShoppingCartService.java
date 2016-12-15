package com.rcp.shopping.cart.service;

import java.util.List;

import com.rcp.shopping.cart.model.Selected;

public interface ShoppingCartService {

	void add(Selected selected);

	void add(Selected selected, String promoCode);

	void total();

	void items(List<Selected> selected);
	
	List<Selected> getSelectedItems();
	
	List<Selected> computeTotalPricePerItem(List<Selected> selected);

}
