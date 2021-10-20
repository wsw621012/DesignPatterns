package com.lucifer.dp.state;

import java.util.ArrayList;
import java.util.List;

public class SimpleQueue<T> {

	private StateEnum state = StateEnum.Empty;

	private final int capacity;

	private List<T> content = new ArrayList<T>();

	public SimpleQueue(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getSize() {
		return content.size();
	}

	public List<T> getContent() {
		return content;
	}

	public boolean push(T t) {
		return state.push(t, this);
	}

	public T pop() {
		return state.pop(this);
	}

	public void setState(StateEnum state) {
		this.state = state;
		System.out.println("State changes to: " + state.toString());
	}
}
