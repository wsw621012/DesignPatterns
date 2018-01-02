package com.lucifer.dp.state;

import java.util.List;

public class FullStateImpl implements State {

	@Override
	public <T> boolean push(T t, SimpleQueue<T> q) {
		return false;
	}

	@Override
	public <T> T pop(SimpleQueue<T> q) {
		List<T> content = q.getContent();
		T t = content.get(0);
		content.remove(0);
		changeState(q, QueueState.Regular);
		return t;
	}

}
