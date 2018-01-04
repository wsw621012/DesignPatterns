package com.lucifer.dp.state;

import com.lucifer.dp.exception.InitFailException;

public enum StateEnum implements State {

	Empty(EmptyStateImpl.class), Regular(RegularStateImpl.class), Full(FullStateImpl.class);

	private final State instance;

	private StateEnum(Class<?> type) {

		try {
			this.instance = (State) type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InitFailException(e);
		}
	}

	@Override
	public <T> boolean push(T t, SimpleQueue<T> q) {
		return instance.push(t, q);
	}

	@Override
	public <T> T pop(SimpleQueue<T> q) {
		return instance.pop(q);
	}

}
