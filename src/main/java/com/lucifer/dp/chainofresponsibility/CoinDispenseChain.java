package com.lucifer.dp.chainofresponsibility;

import java.util.Map;

public interface CoinDispenseChain {

	public Map<Coin, Integer> dispense(int amount);
}
