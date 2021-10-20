package com.lucifer.dp.chain.example2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.chain.example2.Coin;
import com.lucifer.dp.chain.example2.CoinExchanger;

public class CoinExchangerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Map<Coin, Integer> coinBox = new HashMap<Coin, Integer>();
		coinBox.put(Coin.Quarter, 10);
		coinBox.put(Coin.Dime, 10);
		coinBox.put(Coin.Nickel, 10);
		coinBox.put(Coin.Pennie, 10);
		
		CoinExchanger ex = new CoinExchanger(coinBox);
		Map<Coin, Integer> result = ex.exchange(41);
		assertEquals(result.get(Coin.Quarter).intValue(), 1);
		assertEquals(result.get(Coin.Dime).intValue(), 1);
		assertEquals(result.get(Coin.Nickel).intValue(), 1);
		assertEquals(result.get(Coin.Pennie).intValue(), 1);
	}

}
