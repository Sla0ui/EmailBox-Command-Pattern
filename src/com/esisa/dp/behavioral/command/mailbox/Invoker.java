package com.esisa.dp.behavioral.command.mailbox;

public class Invoker extends Thread{
	private Command command;
	private boolean repeat;
	public Invoker(Command command, boolean repeat) {
		super();
		this.command = command;
		this.repeat = repeat;
	}
	
	@Override
	public void run() {
		do {
			try {
				System.out.println("Attendre 2 sec");
				Thread.sleep(2000);
				
				command.execute();
				
				System.out.println("Attendre 2 sec");
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				System.out.println("Interrupted");
				break;
			}
		}while (repeat);
	}

}
