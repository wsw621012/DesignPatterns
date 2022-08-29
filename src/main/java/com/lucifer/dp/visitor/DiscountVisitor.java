package com.lucifer.dp.visitor;

public class DiscountVisitor implements Visitor {

	private double amount;
	private int count;
	private final double discount;
	private final int threshold;
	private final BookCategory category;
	
	public DiscountVisitor(BookCategory category, int threshold, double discount) {
		this.threshold = threshold;
		this.category = category;
		this.discount = discount;
	}
	
	@Override
	public void visitBook(Book book) {
		amount += book.getPrice();
		if (category == book.getCategory()) {
			++count;
		}
	}

	public double getAmount() {
		return (count >= threshold  ? amount * discount : amount);
	}	
}
