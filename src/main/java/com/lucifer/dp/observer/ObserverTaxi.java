package com.lucifer.dp.observer;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ObserverTaxi implements Observer {

	private class Job {
		public UUID id;
		public SubjectTaxiCentre centre;
		
		public Job(UUID id, SubjectTaxiCentre centre) {
			this.id = id;
			this.centre = centre;
		}
	}
	
	private final Queue<Job> jobs = new ConcurrentLinkedQueue<>();

	private final String id;
	
	public String getId() {
		return id;
	}

	public ObserverTaxi(String id, SubjectTaxiCentre centre) {
		this.id = id;
		
		CompletableFuture.runAsync(() -> {
			Job j;
			while (true) {
				try {
					synchronized (jobs) {
						j = jobs.poll();
					}
					if (j == null) {
						Thread.sleep(1000);
						continue;
					}

					if (!j.centre.mediate(j.id, this)) {
						continue;
					}

					System.out.println(MessageFormat.format("{0}: got job {1}", id, j.id));

					Thread.sleep((int) (Math.random() * 2000) + 3000);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
					break;
				}
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		synchronized(jobs) {
			jobs.add(new Job((UUID) arg1, (SubjectTaxiCentre) arg0));
		}
		
	}
	
}
