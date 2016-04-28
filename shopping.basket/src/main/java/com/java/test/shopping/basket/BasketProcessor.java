package com.java.test.shopping.basket;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.java.test.shopping.enumeration.Fruit;
import com.java.test.shopping.enumeration.Offer;

/**
 * 
 * @author Riz
 *
 */
public class BasketProcessor {

	Map<Fruit, Offer> fruitOfferMap = new HashMap<>();

	public BasketProcessor() {
		fruitOfferMap.put(Fruit.APPLE, Offer.BUY_ONEGET_ONEFREE);
		fruitOfferMap.put(Fruit.ORANGE, Offer.THREE_FORTHEPRICEOF_TWO);
	}

	/**
	 * calculate basket Totals
	 * 
	 * @param basketItems
	 */
	public double calculateBasketTotal(Map<Fruit, Integer> basketItems) {

		System.out.println("entry method calculateBasketTotal");
		Double basketPriceGrandTotal = 0.0;
		int totalNumberOfItems = 0;

		for (Entry<Fruit, Integer> item : basketItems.entrySet()) {
			System.out.println("item=" + item.getKey() + " " + item.getValue());
			int currentItemCount = item.getValue();

			switch (item.getKey()) {
			case APPLE:
				// check for an offer
				if (Offer.BUY_ONEGET_ONEFREE == fruitOfferMap.get(Fruit.APPLE)) {
					// buy one get one free

					while (currentItemCount != 0 && currentItemCount > 1) {
						currentItemCount -= 2;
						totalNumberOfItems += 2;
						// price remains the same
						basketPriceGrandTotal += Fruit.APPLE.getPrice();
					}

					if (currentItemCount == 1) {
						currentItemCount = 0;
						System.out.println("Notify customer that they need to pickup another 1 free Apple from the fruit isle");
						totalNumberOfItems += 2;
						// price remains the same
						basketPriceGrandTotal += Fruit.APPLE.getPrice();
					}

				}
				break;
			case ORANGE:
				totalNumberOfItems += currentItemCount;
				// check for an offer
				if (Offer.THREE_FORTHEPRICEOF_TWO == fruitOfferMap.get(Fruit.ORANGE)) {
					int lessThanTree=0;
					while (currentItemCount > 0) {
						// check if more than 3 or more bought
						if (currentItemCount >= 3) {
							System.out.println("applying Three for the price of Two discount for Oranges");
							basketPriceGrandTotal += Fruit.ORANGE.getPrice() * 2;
							currentItemCount -= 3;
						} else {
							// now handling less than 3 oranges
							// assumption is that after less than 3 customer
							// shall pay normal price on the rest
							lessThanTree++;
							
							basketPriceGrandTotal += currentItemCount * Fruit.ORANGE.getPrice();
							currentItemCount -= currentItemCount;
						}
					}
					
					if(lessThanTree==2){
						System.out.println("Notify customer that they need to pickup another 1 free Orange from the fruit isle");
						
					}

				}
				break;

			default:
				// process as normal
				totalNumberOfItems += currentItemCount;
				basketPriceGrandTotal += item.getKey().getPrice() * currentItemCount;
			}

		}

		System.out.println("Total item count==" + totalNumberOfItems + " TotalPrice to pay==" + basketPriceGrandTotal);
		System.out.println("exit method calculateBasketTotal");
		return basketPriceGrandTotal;

	}

}
