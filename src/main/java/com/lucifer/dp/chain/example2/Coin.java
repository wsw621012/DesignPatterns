package com.lucifer.dp.chain.example2;

public enum Coin {
	Pennie(1),
    Nickel(5),
    Dime(10),
    Quarter(25);
	
	private final int value;
	
	Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
