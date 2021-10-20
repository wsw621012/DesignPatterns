package com.lucifer.dp.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

import com.lucifer.dp.exception.NotEnoughChangeException;

public class NullCoinDispenser extends CoinDispenser {

	public NullCoinDispenser() {
		super(null, 0);
	}
	
	@Override
	public Map<Coin, Integer> dispense(int amount) {
		if (amount > 0) {
			throw new NotEnoughChangeException();
		}
		
		return new HashMap<Coin, Integer>();
	}

}
