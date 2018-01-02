package com.lucifer.dp.state;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucifer.dp.state.SimpleQueue;

public class SimpleQueueTest {

	@Test
	public void test() {
		SimpleQueue<Integer> queue = new SimpleQueue<>(5);
		
		assertTrue(queue.push(0));
		assertTrue(queue.push(1));
		assertTrue(queue.push(2));
		assertTrue(queue.push(3));
		assertTrue(queue.push(4));
		
		// test full
		assertFalse("insert 6th", queue.push(5));
		
		// test size should less than or equal to capacity
		assertEquals(queue.getSize(), 5);
		
		assertEquals(queue.pop().intValue(), 0);
		assertEquals(queue.pop().intValue(), 1);
		assertEquals(queue.pop().intValue(), 2);
		assertEquals(queue.pop().intValue(), 3);
		assertEquals(queue.pop().intValue(), 4);
		
		// test pop when empty.
		assertNull(queue.pop());
	}

}
