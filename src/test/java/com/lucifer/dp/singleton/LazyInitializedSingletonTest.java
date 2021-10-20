package com.lucifer.dp.singleton;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.singleton.LazyInitializedSingleton;

public class LazyInitializedSingletonTest {

	private List<String> shapeNames;

	@Before
	public void setUp() throws Exception {
		shapeNames = Arrays.asList("Circle", "Ellipse", "Rectangle", "Square", "Triangle");
	}

	@Test
	public void testSingleton() {
		FactoryUseNameSpace fus = LazyInitializedSingleton.getInstance();

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

	@Test
	public void testMultiThread() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		List<Future> fs = new ArrayList<Future>();
		
		for (int i = 0; i < 4; i++) {
			Future f = executorService.submit(() -> {
				FactoryUseNameSpace fus = LazyInitializedSingleton.getInstance();

				for (String n : shapeNames) {
					
					try {
						fus.create(n).draw();
						Thread.sleep(1000);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			fs.add(f);
		}
		
		for (Future f : fs) {
			try {
				f.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
