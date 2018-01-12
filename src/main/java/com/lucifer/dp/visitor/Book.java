package com.lucifer.dp.visitor;

public abstract class Book implements Visitable {

	private final BookCategory category;
	private final double price;
	
	public Book(BookCategory title, double price) {
		this.category = title;
		this.price = price;
	}

	public BookCategory getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitBook(this);
	}
}
