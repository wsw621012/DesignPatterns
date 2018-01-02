package com.lucifer.dp.state;

public class EmptyStateImpl implements State {

	@Override
	public <T> boolean push(T t, SimpleQueue<T> q) {
		q.getContent().add(t);
		changeState(q, QueueState.Regular);
		return true;
	}

	@Override
	public <T> T pop(SimpleQueue<T> q) {
		return null;
	}

}
