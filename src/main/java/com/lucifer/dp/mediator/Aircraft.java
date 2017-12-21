package com.lucifer.dp.mediator;

import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Aircraft {

	private AirTrafficControlCentre atcc;

	private AtomicInteger currentAltitude;

	private String callSign;

	protected Aircraft(String callSign, AirTrafficControlCentre atcc, int initAltitude) {
		this.callSign = callSign;
		this.atcc = atcc;
		this.currentAltitude = new AtomicInteger(initAltitude);
		atcc.register(this);
	}

	public String getCallSign() {
		return callSign;
	}

	public int getAltitude() {
		return currentAltitude.get();
	}

	public synchronized void changeAltitude(int altitude) {
		if (altitude < 0) {
			altitude = 0;
		}
		currentAltitude.set(altitude);
		atcc.receiveAircraftLocation(this);
	}

	public void climb(int height) {
		this.changeAltitude(currentAltitude.get() + height);
	}

	public void receiveWarnnig(Aircraft aircraft) {
		String msg = MessageFormat.format("WARN: {0}({1}) approach {2}({3}).", aircraft.getCallSign(),
				aircraft.getAltitude(), this.callSign, this.currentAltitude.get());
		System.out.println(msg);
	}
}
