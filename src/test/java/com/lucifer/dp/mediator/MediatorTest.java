package com.lucifer.dp.mediator;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.junit.Before;
import org.junit.Test;

public class MediatorTest {

	private final Executor executor = Executors.newFixedThreadPool(4);

	private final Tower t = new Tower();

	private List<Aircraft> aircrafts;

	@Before
	public void init() {
		aircrafts = Arrays.asList(new Airbus("A-20", t), new Boeing("B-10", t), new Fokker("F-30", t));
	}

	@Test
	public void test() {
		aircrafts.forEach(ac -> {
			CompletableFuture.runAsync(() -> {
				while (ac.getAltitude() > 0) {
					ac.climb((int) (500 * (Math.random() - 1)) - 1000);

					try {
						Thread.sleep(1000 + (long) Math.random() * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(MessageFormat.format("{0} is landing.", ac.getCallSign()));
				t.deregister(ac);
			}, executor);
		});

		try {
			for (int i = 0; i < 20; i++) {
				Thread.sleep(1000);
				t.screen();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
