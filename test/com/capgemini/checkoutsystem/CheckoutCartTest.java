package com.capgemini.checkoutsystem;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import com.capgemini.checkoutsystem.CheckoutCart;

public class CheckoutCartTest {

	private CheckoutCart checkoutCart;	
	
	@Before
	public void setUp()
	{
		checkoutCart = new CheckoutCart(); 
	}
	
	@Test(expected=Exception.class)
	public void testGetTotalCostWithNull() throws Exception
	{
		checkoutCart.getTotalCost(null);
	}
	
	@Test
	public void testGetTotalCostWithNoItem() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		
		//Act and Assert
		assertEquals("£0.00", checkoutCart.getTotalCost(items));
	}
	
	@Test
	public void testGetTotalCostWithAnApple() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		items.add("Apple");
		
		//Act and Assert
		assertEquals("£0.60", checkoutCart.getTotalCost(items));
	}
	
	@Test
	public void testGetTotalCostWithAnOrange() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		items.add("Orange");
		
		//Act and Assert
		assertEquals("£0.25", checkoutCart.getTotalCost(items));
	}
	
	@Test(expected=Exception.class)
	public void testGetTotalCostWithAPear() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		items.add("Pear");
		
		//Act and Assert
		assertEquals("£0.00", checkoutCart.getTotalCost(items));
	}	
	
	@Test(expected = Exception.class)
	public void testGetTotalCostWithApplesAndPear() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		items.add("Apple");
		items.add("Apple");
		items.add("Apple");
		items.add("Pear");
		items.add("Apple");
		
		//Act and Assert
		assertEquals("£0.00", checkoutCart.getTotalCost(items));
	}	
	
	@Test
	public void testGetTotalCostWithMultipleApples() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		items.add("Apple");
		items.add("Apple");
		items.add("Apple");
		items.add("Apple");
		items.add("Apple");
		
		//Act and Assert
		assertEquals("£1.80", checkoutCart.getTotalCost(items));		
	}
	
	@Test
	public void testGetTotalCostWithMultipleOranges() throws Exception
	{
		// Arrange
		List<String> items = new ArrayList<String>();
		items.add("Orange");
		items.add("Orange");
		items.add("Orange");		
		
		//Act and Assert
		assertEquals("£0.50", checkoutCart.getTotalCost(items));		
	}
	
	@Test
	public void testGetTotalCostWithApplesAndOranges() throws Exception
	{
		//Arrange
		List<String> items = new ArrayList<String>();
		items.add("Orange");
		items.add("Apple");
		items.add("Orange");
		items.add("Apple");
		items.add("Orange");
		
		//Act and Assert
		assertEquals("£1.10", checkoutCart.getTotalCost(items));		
	}	
}
