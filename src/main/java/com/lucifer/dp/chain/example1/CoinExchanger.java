package com.lucifer.dp.chain.example1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lucifer.dp.exception.NotEnoughChangeException;

public class CoinExchanger {

	private Map<Coin, Integer> coinBox;

	CoinExchanger(Map<Coin, Integer> coinBox) {
		this.coinBox = coinBox;
	}

	public Map<String, Integer> exchange(int amount) {

		Map<String, Integer> result = new HashMap<String, Integer>();

		List<Coin> coins = coinBox.entrySet().stream().filter(c -> (c.getValue().intValue() > 0))
				.sorted((a, b) -> Integer.compare(b.getKey().getDenomination(),
						a.getKey().getDenomination()))
				.map(c -> c.getKey()).collect(Collectors.toList());

		for (Coin coin : coins) {
			int remain = coinBox.get(coin).intValue();
			int number = coin.floor(amount);
			if (number <= remain) {
				result.put(coin.getName(), number);
				coinBox.put(coin, remain - number);
				amount -= coin.amount(number);
			} else {
				result.put(coin.getName(), remain);
				coinBox.put(coin, 0);
				amount -= coin.amount(remain);
			}

			if (amount <= 0) {
				break;
			}
		}

		if (amount > 0) {
			// rollback
			for (Coin coin : coinBox.keySet()) {
				Integer number = result.get(coin.getName());
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
}
