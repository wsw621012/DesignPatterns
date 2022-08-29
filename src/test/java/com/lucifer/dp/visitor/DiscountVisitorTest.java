package com.lucifer.dp.visitor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DiscountVisitorTest {

	private final List<Book> books = new ArrayList<>();
	
	@Before
	public void init() {
		books.add(new ScienceBook(1500.0));
		books.add(new ScienceBook(2000.0));
		books.add(new ScienceBook(2000.0));
		books.add(new ScienceBook(2500.0));
		books.add(new ScienceBook(3000.0));
		
		books.add(new TravelBook(500.0));
		books.add(new TravelBook(600.0));
		books.add(new TravelBook(700.0));
		books.add(new TravelBook(800.0));
		books.add(new TravelBook(900.0));
		
		books.add(new RomanceBook(200.0));
		books.add(new RomanceBook(210.0));
		books.add(new RomanceBook(220.0));
		books.add(new RomanceBook(230.0));
		books.add(new RomanceBook(240.0));
		books.add(new RomanceBook(250.0));
		books.add(new RomanceBook(260.0));
		books.add(new RomanceBook(270.0));
		books.add(new RomanceBook(280.0));
		
	}
	
	@Test
	public void test() {
		DiscountVisitor dv = new DiscountVisitor(BookCategory.Science, 3, 0.8);
		for (Book b : books) {
			b.accept(dv);
		}
		
		double amount = books.stream().mapToDouble(m -> m.getPrice()).sum() * 0.8;
		
		assertEquals(amount, dv.getAmount(), 0.001);
	}

}
