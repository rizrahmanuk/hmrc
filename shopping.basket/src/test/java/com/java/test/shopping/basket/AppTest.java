package com.java.test.shopping.basket;

import static org.mockito.Mockito.*;

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

import com.java.test.shopping.basket.App;
import com.java.test.shopping.basket.BasketProcessor;
import com.java.test.shopping.enumeration.Fruit;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest {
	private Map<Fruit, Integer> basketItems = new HashMap<>();

	@Mock
	BasketProcessor basketProcessor;

	@InjectMocks
	private final App classUnderTest = new App();

	@Before
	public void setup() {

	}

	/**
	 * Test call to BasketProcessor mocked
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testCalculateBasketTotal() throws FileNotFoundException {
		
		basketItems.put(Fruit.APPLE, 2);
		double expectedTotalPrice = 60.0;

		when(basketProcessor.calculateBasketTotal(Mockito.anyMap())).thenReturn(expectedTotalPrice);
		double totalPrice = classUnderTest.processBasketData();

		Assert.assertEquals(totalPrice, expectedTotalPrice, 0.0);
	}
}
