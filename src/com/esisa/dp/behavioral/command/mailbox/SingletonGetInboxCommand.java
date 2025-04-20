package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;

public class SingletonGetInboxCommand implements Command{

//	private MailBox mailBox;
	
//	
//	public GetInboxCommand(MailBox mailBox) {
//		this.mailBox = mailBox;
//	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<Mail> inbox = MailBoxSingleton.getInstance().getInbox();
		System.out.println("Inbox");
		for (Mail mail : inbox) {
			System.out.println(mail);
		}
		System.out.println("Fin Inbox");
	}
}
