package com.lucifer.dp.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoinDispenser implements CoinDispenseChain {

	private final Coin coin;

	private int count;
	
	private CoinDispenser nextChain;

	public CoinDispenser(Coin coin, int count) {
		this.coin = coin;
		this.count = count;
	}
	
	@JsonCreator
	public CoinDispenser(@JsonProperty("next") CoinDispenser next, @JsonProperty("coin") Coin coin, @JsonProperty("count") int count) {
		this(coin, count);
		this.nextChain = next;
	}

//	public Map<Coin, Integer> dispense(int amount, CoinDispenseChain a) {
//		return a.dispense(amount);
//	}
	
	@Override
	public Map<Coin, Integer> dispense(int amount) {

		int given = canGive(amount);
		
		int balance = amount - (given * coin.getValue());

		Map<Coin, Integer> result = new HashMap<>();
		result.put(coin, given);		
		
//		if (balance > 0) {
//			if (this.nextChain == null) {
//				throw new NotEnoughChangeException(String.format("%s is not enough", coin));
//			}
//			result.putAll(this.nextChain.dispense(balance));
//		}
		
		if (balance > 0) {
			result.putAll(this.nextChain.dispense(balance));
		}
		count -= given;
		return result;
	}

	private int canGive(int amount) {
		return Math.min(count, amount/coin.getValue());
//		int given = amount / coin.getValue();
//		return (given <= count) ? given : count;
	}
}
