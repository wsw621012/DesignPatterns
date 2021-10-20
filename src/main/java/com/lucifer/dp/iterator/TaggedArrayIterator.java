package com.lucifer.dp.iterator;

import java.util.Iterator;

public class TaggedArrayIterator<E> implements Iterator<E> {

	private final E[] array;
	private int origin; // current index, advanced on split or traversal
	private final int fence; // one past the greatest index

	public TaggedArrayIterator(E[] array, int origin, int fence) {
		this.array = array;
		this.origin = origin;
		this.fence = fence;
	}

	@Override
	public boolean hasNext() {
		return origin < fence;
	}

	@Override
	public E next() {
		E data = array[origin];
		origin += 2;
		return data;
	}

}
