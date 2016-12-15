package com.rcp.shopping.cart.main;

import java.util.List;

import com.rcp.shopping.cart.constants.Constants;
import com.rcp.shopping.cart.model.Product;
import com.rcp.shopping.cart.model.Selected;
import com.rcp.shopping.cart.service.ShoppingCartServiceImpl;

public class Main {

	public static void main(String[] args) {

		ShoppingCartServiceImpl shoppingCartServiceImpl = new ShoppingCartServiceImpl();

		Product small = new Product(Constants.UNLI_ONE_GB_CODE, Constants.UNLI_ONE_GB_NAME,
				Constants.UNLI_ONE_GB_PRICE);
		Product medium = new Product(Constants.UNLI_TWO_GB_CODE, Constants.UNLI_TWO_GB_NAME,
				Constants.UNLI_TWO_GB_PRICE);
		Product large = new Product(Constants.UNLI_FIVE_GB_CODE, Constants.UNLI_FIVE_GB_NAME,
				Constants.UNLI_FIVE_GB_PRICE);
		Product oneGb = new Product(Constants.UNLI_ONE_GB_DATA_PACK_CODE, Constants.UNLI_ONE_GB_DATA_PACK_NAME,
				Constants.UNLI_ONE_GB_DATA_PACK_PRICE);

		/* Comment/uncomment to activate or deactivate the Promotion Code */
//		String promoCode = "I<3AMAYSIM";
		 String promoCode = "";

		/* Change the 2nd parameter for the count of the selected item */
		Selected smallSelected = new Selected(small, 3);
		Selected mediumSelected = new Selected(medium, 2);
		Selected largeSelected = new Selected(large, 1);
		Selected oneGbSelected = new Selected(oneGb, 1);

		/* Comment/Uncomment to add the selected item/s*/
		if (Constants.PROMO_CODE.equals(promoCode)) {
			shoppingCartServiceImpl.add(smallSelected, promoCode);
			// shoppingCartServiceImpl.add(mediumSelected, promoCode);
			// shoppingCartServiceImpl.add(largeSelected, promoCode);
			shoppingCartServiceImpl.add(oneGbSelected, promoCode);
		} else {
			shoppingCartServiceImpl.add(smallSelected);
//			shoppingCartServiceImpl.add(mediumSelected);
			 shoppingCartServiceImpl.add(largeSelected);
			// shoppingCartServiceImpl.add(oneGbSelected);
		}

		List<Selected> selected = shoppingCartServiceImpl.getSelectedItems();

		List<Selected> computedTotalPricePerItem = shoppingCartServiceImpl.computeTotalPricePerItem(selected);

		shoppingCartServiceImpl.items(computedTotalPricePerItem);
		shoppingCartServiceImpl.total();
		
	}

}
