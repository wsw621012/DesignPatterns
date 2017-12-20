package com.lucifer.dp.mediator;

import java.util.UUID;

public interface Colleague {

	String getId();
	
	boolean sendMessage(String to, String message);
	
	void receiveMessage(String from, String message);
	
	void take(UUID jobId, String message);
}
