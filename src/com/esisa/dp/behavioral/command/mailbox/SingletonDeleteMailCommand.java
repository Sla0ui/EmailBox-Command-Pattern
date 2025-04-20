package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;
import java.util.Random;

public class SingletonDeleteMailCommand implements Command{

//	private MailBox mailBox;
	private Random random;
	
	
	public SingletonDeleteMailCommand(MailBox mailBox) {
		super();
//		this.mailBox = mailBox;
		this.random = new Random();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<Mail> inbox = MailBoxSingleton.getInstance().getInbox();
		if(!inbox.isEmpty()) {
			int randomIndex = random.nextInt(inbox.size());
			int id = inbox.get(randomIndex).getId();
			MailBoxSingleton.getInstance().deleteMail(id);
		}else {
			System.out.println("No mails to delete");
		}
	}
}
