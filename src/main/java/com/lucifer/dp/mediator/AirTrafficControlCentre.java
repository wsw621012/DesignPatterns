package com.lucifer.dp.mediator;

public interface AirTrafficControlCentre {
	
	void register(Aircraft aircraft);
	
	void deregister(Aircraft aircraft);
	
	void receiveAircraftLocation(Aircraft aircraft);

}
