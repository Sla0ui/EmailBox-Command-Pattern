package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;
import java.util.Vector;

public class SingletonMacroCommand implements Command{

	private List<Command> commands;
	


	public SingletonMacroCommand(List<Command> commands) {
		super();
		this.commands = new Vector<Command>();
	}

	public SingletonMacroCommand(Command... commands) {
		this.commands = new Vector<Command>();
		for (int i = 0; i < commands.length; i++) {
			this.commands.add(commands[i]);
		}
	}
	
	public void add(Command command) {
		commands.add(command);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(Command command : commands) {
			command.execute();
		}
	}

}
