package com.lucifer.dp.state;

import java.util.List;

public class RegularStateImpl implements State {

	@Override
	public <T> boolean push(T t, SimpleQueue<T> q) {
		q.getContent().add(t);
		if (q.getSize() >= q.getCapacity()) {
			changeState(q, QueueState.Full);
		}
		return true;
	}

	@Override
	public <T> T pop(SimpleQueue<T> q) {
		List<T> content = q.getContent();
		T t = content.get(0);
		content.remove(0);
		if (content.size() == 0) {
			changeState(q, QueueState.Empty);
		}
		return t;
	}
}
