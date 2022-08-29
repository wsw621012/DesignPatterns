package com.lucifer.dp.command.traditional;

public class Receiver {

	private final Command cmd;
	
	public Receiver(Command cmd) {
		this.cmd = cmd;
	}
	
	public void action() {
		cmd.execute();
	}
}
