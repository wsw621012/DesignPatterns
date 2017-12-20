package com.lucifer.dp.chainofresponsibility;

public enum Coin {
	Pennie(1),
    Nickel(5),
    Dime(10),
    Quarter(25);
	
	private int value;
	
	private Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
