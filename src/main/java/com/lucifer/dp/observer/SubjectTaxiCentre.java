package com.lucifer.dp.observer;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Observable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SubjectTaxiCentre extends Observable {

	private final Map<UUID, String> requests = new ConcurrentHashMap<>();
	
	public void register(ObserverTaxi taxi) {
		super.addObserver(taxi);
	}

	public void customerRequest(String message) {
		UUID jobId = UUID.randomUUID();
		System.out.println(MessageFormat.format("Brocast: new request({0}), message:{1})", jobId, message));
		synchronized (requests) {
			requests.put(jobId, message);
			super.setChanged();
			super.notifyObservers(jobId);
		}
	}

	public boolean mediate(UUID jobId, ObserverTaxi c) {
		if (!requests.containsKey(jobId)) {
			return false;
		}
		
		synchronized (requests) {
			if (requests.remove(jobId) != null) {
				System.out.println(MessageFormat.format("Brocast: {0} got job {1})", c.getId(), jobId));
				return true;
			}
		}
		return false;
	}
}
