package com.java.test.shopping.enumeration;

/**
 * 
 * @author Riz
 *
 */
public enum Fruit {
	APPLE(60),
	ORANGE(25);
	
	private int price;
	
	private Fruit(int price){
		this.price=price;
	}
	
	public int getPrice(){
		return price;
	}
}
