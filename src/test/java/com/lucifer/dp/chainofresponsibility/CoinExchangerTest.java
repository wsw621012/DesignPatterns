package com.lucifer.dp.chainofresponsibility;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.chainofresponsibility.Coin;
import com.lucifer.dp.chainofresponsibility.CoinDispenser;
import com.lucifer.dp.chainofresponsibility.NullCoinDispenser;
import com.lucifer.dp.exception.NotEnoughChangeException;
import com.lucifer.dp.utils.JsonConverter;

public class CoinExchangerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {

		int amount = 41;

		CoinDispenser ex = new NullCoinDispenser();
		ex = new CoinDispenser(ex, Coin.Pennie, 10);
		ex = new CoinDispenser(ex, Coin.Nickel, 10);
		ex = new CoinDispenser(ex, Coin.Dime, 10);
		ex = new CoinDispenser(ex, Coin.Quarter, 10);

		System.out.println(JsonConverter.serialize(ex));

		Map<Coin, Integer> result = ex.dispense(amount);
		assertEquals(result.get(Coin.Quarter).intValue(), 1);
		assertEquals(result.get(Coin.Dime).intValue(), 1);
		assertEquals(result.get(Coin.Nickel).intValue(), 1);
		assertEquals(result.get(Coin.Pennie).intValue(), 1);

		int resultAmount = result.entrySet().stream()
				.mapToInt(o -> o.getValue() * o.getKey().getValue()).sum();
		assertEquals(resultAmount, amount);
	}

	@Test(expected = NotEnoughChangeException.class)
	public void test2() {
		CoinDispenser ex = new NullCoinDispenser();
		ex = new CoinDispenser(ex, Coin.Pennie, 1);
		ex = new CoinDispenser(ex, Coin.Nickel, 1);
		ex = new CoinDispenser(ex, Coin.Dime, 1);
		ex = new CoinDispenser(ex, Coin.Quarter, 1);
		
		ex.dispense(43);

//		try {
//			ex.dispense(43);
//			fail();
//		} catch (NotEnoughChangeException e) {
//			System.out.println(e);
//		}
	}

	@Test
	public void test3() {

		CoinDispenser ex = JsonConverter.deserialize(Paths.get("json", "CoinDispenser.json"),
				CoinDispenser.class);

		int amount = 41;

		Map<Coin, Integer> result = ex.dispense(amount);
		assertEquals(result.get(Coin.Quarter).intValue(), 1);
		assertEquals(result.get(Coin.Dime).intValue(), 1);
		assertEquals(result.get(Coin.Nickel).intValue(), 1);
		assertEquals(result.get(Coin.Pennie).intValue(), 1);

		int resultAmount = result.entrySet().stream()
				.mapToInt(o -> o.getValue() * o.getKey().getValue()).sum();
		assertEquals(resultAmount, amount);

	}
}
