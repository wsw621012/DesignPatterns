package com.lucifer.dp.singleton;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.singleton.BillPughSingleton;

public class BillPughSingletonTest {

	private List<String> shapeNames;
	
	@Before
	public void setUp() throws Exception {
		shapeNames = Arrays.asList("Circle", "Ellipse", "Rectangle", "Square", "Triangle");
	}

	@Test
	public void testSingleton() {
		FactoryUseNameSpace fus = BillPughSingleton.getInstance();
		
		shapeNames.forEach(n -> {
			try {
				fus.create(n).draw();				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}

}
