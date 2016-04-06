/**
 * Created - 05/04/2016 - To calculate the checkout cost of apples and oranges
 * Modified- 06/04/2016
 *  			 applyXForYOffer method added to provide any offer discount
 *  			 Amended to accept the command line arguments 
 */
package com.capgemini.checkoutsystem;

import java.util.*;
import java.text.*;

/**
 * @author Jayshri Patil
 * @Description - A CheckoutCart class file to handle total checkout price for items purchased 
 *  
 */
public class CheckoutCart {
	
	private DecimalFormat FORMATTER = new DecimalFormat ("£0.00");
	
	public static void main(String args[]) throws Exception 
		{
	           List<String> itemsList = new ArrayList<String>();
			   int i,len;
			   
			   len=args.length;
			   for(i=0;i<len;i++)
			   {
				   itemsList.add(args[i]);
			   }

			   //display input check out item
			   System.out.println("\n Items to check out : ");
			   for(i=0;i<len;i++)
			       System.out.println("Item "+(i+1)+"  is "+args[i]);
			   
			 //display total price
			 if (len > 0) {
				 CheckoutCart checkOutTotalPrice = new CheckoutCart();
				 System.out.println("\nTotal Price to Pay :" +checkOutTotalPrice.getTotalCost(itemsList));
			 } else {
				 System.out.println("\n Item cart is empty");
			 }
			 
			   
	  }	
	

	/**
	 * Method to return total cost of items to be checked out
	 * @param items - list of items added in the basket
	 * @return total cost
	 * @throws Exception
	 */
	/**
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public String getTotalCost (List<String> items) throws Exception {
		int appleCount = 0;
		int orangeCount = 0;
		
		if (items == null) {
			throw new Exception("Invalid item");
		}
		
		for (String item : items) {
			if (item.equals("Apple")) {
				appleCount ++;
			}
			else if (item.equals("Orange")) {
				orangeCount ++;
			} else {
				throw new Exception("\n Invalid item - "+item +" identified in the basket.");
			}		
		}
		
		double applePrice = applyXForYOffer(2, 1, appleCount, 0.60);
		
		double orangePrice = applyXForYOffer(3, 2, orangeCount, 0.25);
		
		return FORMATTER.format(applePrice + orangePrice);
	}
	
	/**
	 * Method that calculates total price on buy x items for y 
	 * @param x - Buy x item
	 * @param y - for y item
	 * @param itemQuantity - item count
	 * @param originalItemPrice - item price
	 * @return - total price post applying offers
	 */
	private double applyXForYOffer(int x, int y, int itemQuantity, double originalItemPrice) {
		int offerPriceQuantity = itemQuantity / x; 
		int remainderQuantity = itemQuantity % x;  
		double offerPrice = offerPriceQuantity * originalItemPrice * y;
		double remainderPrice = remainderQuantity * originalItemPrice;
		
		return offerPrice + remainderPrice;
	}	
}
