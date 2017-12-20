package com.lucifer.dp.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TaggedArray<T> implements Iterable<T> {

	private final T[] elements; // immutable after construction

	@SuppressWarnings("unchecked")
	public TaggedArray(T[] data, T[] tags) {
		int size = data.length;
		if (tags.length != size)
			throw new IllegalArgumentException();
		this.elements = (T[]) new Object[2 * size];
		for (int i = 0, j = 0; i < size; ++i) {
			elements[j++] = data[i];
			elements[j++] = tags[i];
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new TaggedArrayIterator<T>(elements, 0, elements.length);
	}
	
	@Override
	public Spliterator<T> spliterator() {
		return new TaggedArraySpliterator<>(elements, 0, elements.length);
	}
	
	public int size() {
		return elements.length / 2;
	}
	
	public Stream<T> stream() {
		return StreamSupport.stream(spliterator(), false);
	}
}
