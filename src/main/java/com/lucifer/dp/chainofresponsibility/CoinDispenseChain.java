package com.lucifer.dp.chainofresponsibility;

import java.util.Map;

public interface CoinDispenseChain {

	Map<Coin, Integer> dispense(int amount);
}
