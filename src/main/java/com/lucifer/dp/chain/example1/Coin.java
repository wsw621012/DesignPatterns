package com.lucifer.dp.chain.example1;

public class Coin {

	private final int denomination;
	
	private final String name;
	
	public Coin(String name, int denomination) {
		this.name = name;
		this.denomination = denomination;
	}
	
	public final int getDenomination() {
		return denomination;
	}
	
	public String getName() {
		return name;
	}
	
	public int amount(int number) {
		return number * denomination;
	}
	
	public int floor(int amount) {
		return amount / denomination;
	}

}
