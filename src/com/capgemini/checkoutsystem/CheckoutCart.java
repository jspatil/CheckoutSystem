/**
 * 
 */
package com.capgemini.checkoutsystem;

import java.util.*;
import java.text.*;

/**
 * @author Jayshri Patil
 * @Description - A CheckoutCart class file to handle 
 * 					a. total checkout price for items purchased 
 *  
 */
public class CheckoutCart {
	
	private static Map <String, Double> ITEMS_MAP = new HashMap<String, Double>();
	
	private DecimalFormat FORMATTER = new DecimalFormat ("£0.00");
	
	static {
		ITEMS_MAP.put("Apple", 0.60);
		ITEMS_MAP.put("Orange", 0.25);
	}
	
	public String getTotalCost (List<String> items) throws Exception {
		double total = 0;
		double price = 0;
		
		for (String item : items) {
			price = ITEMS_MAP.get(item);
			total += price;
		}
		
		return FORMATTER.format(total);
	}
}
