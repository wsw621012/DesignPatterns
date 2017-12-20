package com.lucifer.dp.chain.example1;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.chain.example1.Coin;
import com.lucifer.dp.chain.example1.CoinExchanger;

public class CoinExchangerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Map<Coin, Integer> coinBox = new HashMap<Coin, Integer>();
		coinBox.put(new Coin("Quarter", 25), 10);
		coinBox.put(new Coin("Dime", 10), 10);
		coinBox.put(new Coin("Nickel", 5), 10);
		coinBox.put(new Coin("Pennie", 1), 10);
		
		CoinExchanger ex = new CoinExchanger(coinBox);
		Map<String, Integer> result = ex.exchange(41);
		assertEquals(result.get("Quarter").intValue(), 1);
		assertEquals(result.get("Dime").intValue(), 1);
		assertEquals(result.get("Nickel").intValue(), 1);
		assertEquals(result.get("Pennie").intValue(), 1);
	}

}
