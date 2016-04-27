package com.java.test.shopping.basket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.java.test.shopping.enumeration.Fruit;

import java.util.Scanner;

/**
 * 
 * @author Riz
 *
 */
public class App {

	private BasketProcessor basketProcessor = new BasketProcessor();

	public static void main(String[] args) {

		App application = new App();
		
		try {
			double totalPrice = application.processBasketData();
			
			System.out.println("total price to pay="+ totalPrice);
			
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFound=" + e.getMessage());
			System.exit(-1);
		}
	}

	public double processBasketData() throws FileNotFoundException {

		System.out.println("entry method processBasketData");

		double totalPrice = 0.0;

		Map<Fruit, Integer> basketItems = new HashMap<>(300);

		File basketFile = new File("src/main/resources/basketitems.txt");
		Scanner scanner = new Scanner(basketFile);

		while (scanner.hasNext()) {
			String currentItem = scanner.nextLine();

			Fruit fruit = Fruit.valueOf(currentItem);
			if (basketItems.containsKey(fruit)) {
				int itemTotal = basketItems.get(fruit);
				basketItems.replace(fruit, ++itemTotal);
			} else {
				// first unique item in the Map
				basketItems.put(fruit, 1);
			}

		}

		totalPrice = basketProcessor.calculateBasketTotal(basketItems);

		System.out.println("Total price for this basket=" + totalPrice);
		System.out.println("exit method processBasketData");
		
		return totalPrice;
	}

}
