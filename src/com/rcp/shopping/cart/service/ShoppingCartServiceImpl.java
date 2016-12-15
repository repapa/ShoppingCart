package com.rcp.shopping.cart.service;

import java.util.ArrayList;
import java.util.List;

import com.rcp.shopping.cart.constants.Constants;
import com.rcp.shopping.cart.model.Product;
import com.rcp.shopping.cart.model.Selected;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private List<Selected> selectedItems = new ArrayList<>();
	private List<Double> totalPricePerItem = new ArrayList<>();
	private double totalOfPrices = 0;

	@Override
	public void add(Selected selected) {
		selectedItems.add(selected);
	}

	@Override
	public void add(Selected selected, String promoCode) {
		selected.setPromoCode(promoCode);
		selectedItems.add(selected);
	}

	@Override
	public void total() {
		for (int k = 0; k < totalPricePerItem.size(); k++) {
			totalOfPrices = totalOfPrices + totalPricePerItem.get(k);
		}
		System.out.println("Cart Total:\n$" + Math.round(totalOfPrices * 100D) / 100D);
	}

	@Override
	public void items(List<Selected> computedTotalPricePerItem) {
		System.out.println("Card Items:");
		for (int j = 0; j < computedTotalPricePerItem.size(); j++) {
			totalPricePerItem.add(computedTotalPricePerItem.get(j).getTotal());
			System.out.println(computedTotalPricePerItem.get(j).getCount() + "x "
					+ computedTotalPricePerItem.get(j).getProduct().getName());
		}
	}

	@Override
	public List<Selected> getSelectedItems() {
		return selectedItems;
	}

	@Override
	public List<Selected> computeTotalPricePerItem(List<Selected> selected) {
		int unliOneGbCountDivisible = 0;
		double deduct = 0;
		for (int i = 0; i < selected.size(); i++) {
			if (Constants.PROMO_CODE.equals(selected.get(i).getPromoCode())) {
				double price = selected.get(i).getProduct().getPrice();
				double discountPrice = price * .10;
				double discountedPrice = price - discountPrice;
				selected.get(i).setTotal(selected.get(i).getCount() * discountedPrice);
			} else {
				selected.get(i).setTotal(selected.get(i).getCount() * selected.get(i).getProduct().getPrice());
			}
			if (Constants.UNLI_ONE_GB_NAME.equals(selected.get(i).getProduct().getName())) {
				unliOneGbCountDivisible = selected.get(i).getCount() / 3;
				if (unliOneGbCountDivisible > 0) {
					deduct = Constants.UNLI_ONE_GB_PRICE * unliOneGbCountDivisible;
					selected.get(i).setTotal(selected.get(i).getTotal() - deduct);
				}
			}
			if (Constants.UNLI_FIVE_GB_NAME.equals(selected.get(i).getProduct().getName())) {
				int unliFiveGbCount = selected.get(i).getCount();
				if (unliFiveGbCount > 3) {
					deduct = unliFiveGbCount * 5;
					selected.get(i).setTotal(selected.get(i).getTotal() - deduct);
				}
			}
			if (Constants.UNLI_TWO_GB_NAME.equals(selected.get(i).getProduct().getName())) {
				int count = selected.get(i).getCount();
				Product addedOneGb = new Product(Constants.UNLI_ONE_GB_DATA_PACK_CODE,
						Constants.UNLI_ONE_GB_DATA_PACK_NAME);
				Selected addedSelection = new Selected(addedOneGb, count);
				selected.add(addedSelection);
			}
		}
		return selected;
	}

}
