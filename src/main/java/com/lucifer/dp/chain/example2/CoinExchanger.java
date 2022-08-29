package com.lucifer.dp.chain.example2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lucifer.dp.exception.NotEnoughChangeException;

public class CoinExchanger {

	private final Map<Coin, Integer> coinBox;
	
	CoinExchanger(Map<Coin, Integer> coinBox) {
		this.coinBox = coinBox;
	}
	
	
	public Map<Coin, Integer> exchange(int amount) {

		Map<Coin, Integer> result = new HashMap<Coin, Integer>();

		List<Coin> coins = coinBox.entrySet().stream().filter(c -> (c.getValue().intValue() > 0))
				.sorted((a, b) -> Integer.compare(b.getKey().getValue(),
						a.getKey().getValue()))
				.map(c -> c.getKey()).collect(Collectors.toList());

		for (Coin coin : coins) {
			int remain = coinBox.get(coin).intValue();
			int number = amount / coin.getValue();
			if (number <= remain) {
				result.put(coin, number);
				coinBox.put(coin, remain - number);
				amount -= coin.getValue() * number;
			} else {
				result.put(coin, remain);
				coinBox.put(coin, 0);
				amount -= coin.getValue() * remain;
			}

			if (amount <= 0) {
				break;
			}
		}

		if (amount > 0) {
			// rollback
			for (Coin coin : coinBox.keySet()) {
				Integer number = result.get(coin);
				if (number != null) {
					int remain = coinBox.get(coin);
					coinBox.put(coin, remain + number.intValue());
				}
			}
			throw new NotEnoughChangeException();
		} else {
			return result;
		}
	}
	
	public int balance() {
		return coinBox.entrySet().stream().mapToInt(c -> c.getValue().intValue() * c.getKey().getValue()).sum();
	}
	
	public boolean isEmpty() {
		return coinBox.values().stream().mapToInt(c -> c.intValue()).sum() == 0;
	}
}
