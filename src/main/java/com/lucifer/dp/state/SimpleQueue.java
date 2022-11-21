package com.lucifer.dp.state;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class SimpleQueue<T> {

	private StateEnum state = StateEnum.Empty;

	@Getter
	private final int capacity;

	@Getter
	private final List<T> content = new ArrayList<T>();

	public SimpleQueue(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return content.size();
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
