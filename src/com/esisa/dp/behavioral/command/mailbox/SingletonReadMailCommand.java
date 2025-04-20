package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;
import java.util.Random;

public class SingletonReadMailCommand implements Command{

//	private MailBox mailBox;
	private Random random;
	
	public SingletonReadMailCommand(MailBox mailBox) {
		super();
//		this.mailBox = mailBox;
		this.random = new Random();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<Mail> inbox = MailBoxSingleton.getInstance().getInbox();
		if (!inbox.isEmpty()) {
			int randomIndex = random.nextInt(inbox.size());
			int id = inbox.get(randomIndex).getId();
			MailBoxSingleton.getInstance().readMail(id);
		}else {
			System.out.println("No mails to read");
		}
	}

}
