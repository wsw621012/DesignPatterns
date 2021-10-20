package com.lucifer.dp.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Rule;
import org.junit.Test;
import org.junit.AssumptionViolatedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import com.lucifer.dp.iterator.TaggedArray;

public class TaggedArrayTest {

	@Rule
	public final Stopwatch stopwatch = new Stopwatch() {
		protected void succeeded(long nanos, Description description) {
			System.out.println(description.getMethodName() + " succeeded, time taken(ms) " + nanos / 1000000);
		}

		protected void failed(long nanos, Throwable e, Description description) {
			System.out.println(description.getMethodName() + " failed, time taken(ms) " + nanos / 1000000);
		}

		protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
			System.out.println(description.getMethodName() + " skipped, time taken(ms) " + nanos / 1000000);
		}

		protected void finished(long nanos, Description description) {
			System.out.println(description.getMethodName() + " finished, time taken(ms) " + nanos / 1000000);
		}

	};

	private TaggedArray<Integer> prepareArray() {
		int[] data = IntStream.range(0, 100).toArray();
		int[] tags = IntStream.range(500, 600).toArray();
		return new TaggedArray<Integer>(IntStream.of(data).boxed().toArray(Integer[]::new),
				IntStream.of(tags).boxed().toArray(Integer[]::new));
	}

	@Test
	public void test() {
		TaggedArray<Integer> ta = prepareArray();

		assertEquals(ta.size(), 100);

		Iterator<Integer> sourceIterator = ta.iterator();
		Iterable<Integer> iterable = () -> sourceIterator;
		Stream<Integer> targetStream = StreamSupport.stream(iterable.spliterator(), false);

		int sum_1 = targetStream.mapToInt(o -> o.intValue()).sum();
		assertEquals(sum_1, 4950);

		int sum_2 = ta.stream().mapToInt(o -> o.intValue()).sum();
		assertEquals(sum_1, sum_2);
	}

	@Test
	public void test2() {
		TaggedArray<Integer> ta = prepareArray();

		Iterator<Integer> sourceIterator = ta.iterator();
		Iterable<Integer> iterable = () -> sourceIterator;
		Stream<Integer> targetStream = StreamSupport.stream(iterable.spliterator(), true);

		assertTrue(targetStream.isParallel());
		
		int sum_2 = targetStream.parallel().mapToInt(o -> o.intValue()).sum();
		assertEquals(sum_2, 4950);
	}

}
