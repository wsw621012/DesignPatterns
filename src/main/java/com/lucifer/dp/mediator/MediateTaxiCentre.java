package com.lucifer.dp.mediator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class MediateTaxiCentre implements Mediator {

	private Map<String, Colleague> colleagues = new ConcurrentHashMap<>();

	private Map<UUID, String> requests = new ConcurrentHashMap<>();

	public void register(Colleague c) {
		colleagues.put(c.getId(), c);
	}

	public void customerRequest(String message) {
		UUID jobId = UUID.randomUUID();
		requests.put(jobId, message);
		System.out.println(MessageFormat.format("New request: id({0}), message:{1})", jobId, message));

		List<CompletableFuture<Void>> r = new ArrayList<>();
		for (Colleague c : colleagues.values()) {
			r.add(CompletableFuture.runAsync(() -> c.take(jobId, message)));
		}
		
		r.forEach(f -> {
			try {
				f.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public boolean mediate(UUID jobId, Colleague c) {
		if (requests.containsKey(jobId)) {
			synchronized (requests) {
				if (requests.remove(jobId) != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean sendMessage(String whom, String message, Colleague from) {
		Colleague c = colleagues.get(whom);
		if (c != null) {
			c.receiveMessage(from.getId(), message);
			return true;
		}
		return false;
	}

}
