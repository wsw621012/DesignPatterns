package com.lucifer.dp.mediator;

import java.text.MessageFormat;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {

	private MediateTaxiCentre center = new MediateTaxiCentre();
	
	@Before
	public void init() {
		for (int i = 0; i < 3; i++) {
			center.register(new Taxi(MessageFormat.format("ID-{0}", i), center));
		}
	}
	
	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			//System.out.println(MessageFormat.format("This is {0}-th job.", i + 1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			center.customerRequest(MessageFormat.format("This is {0}-th job.", i + 1));
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
