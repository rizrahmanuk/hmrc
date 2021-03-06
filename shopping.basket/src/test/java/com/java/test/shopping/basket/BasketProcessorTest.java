package com.java.test.shopping.basket;

import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.test.shopping.basket.BasketProcessor;
import com.java.test.shopping.enumeration.Fruit;

/**
 * Unit tests for BasketProcessor Apples 60p each (buy-one-get-one-free) Oranges
 * 25p each (three=for-the-price-of-two)
 */
@RunWith(MockitoJUnitRunner.class)
public class BasketProcessorTest {

	private final BasketProcessor classUnderTest = new BasketProcessor();

	@Before
	public void setup() {
	}

	/**
	 * Assumption is that the for the free apple the machine/person informs the
	 * buyer that there is an offer, message will be displayed to assist
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_1_Apple_0_OrangesDiscount() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 1);
		basketItems.put(Fruit.ORANGE, 0);

		double expectedTotalPrice = 60.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}

	/**
	 * Buyer only wants to buy one Orange
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_0_Apple_1_Oranges() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 0);
		basketItems.put(Fruit.ORANGE, 1);

		double expectedTotalPrice = 25.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}
	
	/**
	 * Buyer only wants to buy 2 Oranges
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_0_Apple_2_OrangesDiscount() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 0);
		basketItems.put(Fruit.ORANGE, 2);

		double expectedTotalPrice = 50.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}

	/**
	 * Assumption is that the third Orange is not in the basket and can be
	 * picked up
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_2_Apple_2_OrangesDiscount() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 2);
		basketItems.put(Fruit.ORANGE, 2);

		double expectedTotalPrice = 110.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}

	/**
	 * Assumption is that the third Orange is in the basket
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_2_Apple_3_OrangesDiscount() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 2);
		basketItems.put(Fruit.ORANGE, 3);

		double expectedTotalPrice = 110.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}

	/**
	 * Assumption is that the third Orange is in the basket, even Multiples of
	 * Apples
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_4_Apples_3_OrangesDiscount() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 4);
		basketItems.put(Fruit.ORANGE, 3);

		double expectedTotalPrice = 170.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}

	/**
	 * Assumption is that the third Orange is in the basket, odd Multiples of
	 * Apples
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test_7_Apples_3_OrangesDiscount() throws FileNotFoundException {
		final Map<Fruit, Integer> basketItems = new HashMap<>();

		basketItems.put(Fruit.APPLE, 7);
		basketItems.put(Fruit.ORANGE, 3);

		double expectedTotalPrice = 290.0;

		double totalPrice = classUnderTest.calculateBasketTotal(basketItems);

		Assert.assertEquals(expectedTotalPrice, totalPrice, 0.0);
	}

}
