package com.lucifer.dp.mediator;

import java.text.MessageFormat;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Taxi implements Colleague {

	private final static Executor executor = Executors.newFixedThreadPool(8);

	private final Mediator taxiCentre;

	private final String id;

	private AtomicBoolean reservable;

	public Taxi(String id, Mediator taxiCentre) {
		this.id = id;
		this.taxiCentre = taxiCentre;
		reservable = new AtomicBoolean(true);
	}

	public void setReservable(boolean reservable) {
		this.reservable.set(reservable);
	}

	@Override
	public void take(UUID jobId, String message) {

		// Driver thinking or pending...
		try {
			Thread.sleep((long) (Math.random() * 5000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		if (!reservable.get()) {
			return;
		}

		if (taxiCentre.mediate(jobId, this)) {
			System.out.println(MessageFormat.format("{0}: got job({1}).", id, jobId));
			setReservable(false);
			executor.execute(() -> {
				try {
					Thread.sleep((int) (Math.random() * 2000) + 5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setReservable(true);
				System.out.println(MessageFormat.format("{0}: complete job({1}).", id, jobId));
			});
		}

	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void receiveMessage(String from, String message) {
		System.out.println(MessageFormat.format("{0}: received from {1} with '{2}'", id, from, message));
	}

	@Override
	public boolean sendMessage(String to, String message) {
		return taxiCentre.sendMessage(to, message, this);
	}

}
