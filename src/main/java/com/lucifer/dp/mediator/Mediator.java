package com.lucifer.dp.mediator;

import java.util.UUID;

public interface Mediator {

	//void register(Object c);
	
	boolean sendMessage(String whom, String message, Colleague from);
	
	boolean mediate(UUID jobId, Colleague c);
}
