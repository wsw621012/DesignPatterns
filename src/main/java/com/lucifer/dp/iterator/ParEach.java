package com.lucifer.dp.iterator;

import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

public class ParEach<T> extends CountedCompleter<Void> {

	private static final long serialVersionUID = -9185753435768964512L;
	
	final Spliterator<T> spliterator;
	final Consumer<T> action;
	final long targetBatchSize;

	ParEach(ParEach<T> parent, Spliterator<T> spliterator, Consumer<T> action, long targetBatchSize) {
		super(parent);
		this.spliterator = spliterator;
		this.action = action;
		this.targetBatchSize = targetBatchSize;
	}

	@Override
	public void compute() {
		Spliterator<T> sub;
	     while (spliterator.estimateSize() > targetBatchSize &&
	            (sub = spliterator.trySplit()) != null) {
	       addToPendingCount(1);
	       new ParEach<>(this, sub, action, targetBatchSize).fork();
	     }
	     spliterator.forEachRemaining(action);
	     propagateCompletion();
	}

}
