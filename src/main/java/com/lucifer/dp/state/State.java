package com.lucifer.dp.state;

public interface State {

	<T> boolean push(T t, SimpleQueue<T> q);

	<T> T pop(SimpleQueue<T> q);

	default <T> void changeState(SimpleQueue<T> queue, StateEnum state) {
		queue.setState(state);
	}

}
