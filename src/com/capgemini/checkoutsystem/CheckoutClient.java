package com.capgemini.checkoutsystem;

import java.util.ArrayList;
import java.util.List;

public class CheckoutClient {

	public static void main(String[] args) throws Exception {
		List<String> itemsList = new ArrayList<String>();
		int i, len;

		len = args.length;
		for (i = 0; i < len; i++) {
			itemsList.add(args[i]);
		}

		// display input check out item
		System.out.println("\n Items to check out : ");
		for (i = 0; i < len; i++)
			System.out.println("Item " + (i + 1) + "  is " + args[i]);

		// display total price
		if (len > 0) {
			CheckoutCart checkOutTotalPrice = new CheckoutCart();
			System.out.println("\nTotal Price to Pay :"
					+ checkOutTotalPrice.getTotalCost(itemsList));
		} else {
			System.out.println("\n Item cart is empty");
		}

	}

}
