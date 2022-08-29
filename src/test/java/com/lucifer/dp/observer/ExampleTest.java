package com.lucifer.dp.observer;

import java.text.MessageFormat;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.observer.ObserverTaxi;
import com.lucifer.dp.observer.SubjectTaxiCentre;

public class ExampleTest {

	private final SubjectTaxiCentre centre = new SubjectTaxiCentre();
	
	@Before
	public void init() {
		for (int i = 0; i < 3; i++) {
			centre.register(new ObserverTaxi(MessageFormat.format("ID-{0}", i), centre));
		}
	}
	
	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			centre.customerRequest(MessageFormat.format("This is {0}-th job.", i + 1));
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//centre.deregisterAll();
	}

}
