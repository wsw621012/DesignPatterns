package com.lucifer.dp.mediator;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tower implements AirTrafficControlCentre {

	Map<String, Aircraft> aircrafts = new ConcurrentHashMap<>();

	@Override
	public void register(Aircraft aircraft) {
		if (!aircrafts.containsKey(aircraft.getCallSign())) {
			aircrafts.put(aircraft.getCallSign(), aircraft);
		}
	}

	@Override
	public void receiveAircraftLocation(Aircraft aircraft) {
		if (aircraft.getAltitude() == 0) {
			return;
		}
		synchronized (this) {
			for (Aircraft ac : aircrafts.values()) {
				if (ac.getCallSign() == aircraft.getCallSign()) {
					continue;
				}
				if (Math.abs(ac.getAltitude() - aircraft.getAltitude()) <= 1000) {
					ac.receiveWarnnig(aircraft);
					aircraft.climb(1000);
				}
			}
		}
	}

	public void screen() {
		StringBuilder sb = new StringBuilder("----- ");
		for (Aircraft a : aircrafts.values()) {
			sb.append(MessageFormat.format("{0}({1}) ", a.getCallSign(), a.getAltitude()));
		}
		sb.append("-----");
		System.out.println(sb);
	}

	@Override
	public void deregister(Aircraft aircraft) {
		aircrafts.remove(aircraft.getCallSign());
	}

}
