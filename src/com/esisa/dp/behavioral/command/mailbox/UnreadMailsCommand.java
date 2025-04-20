package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;

public class UnreadMailsCommand implements Command{
	
	private MailBox mailBox;
	
	public UnreadMailsCommand(MailBox mailBox) {
		super();
		this.mailBox = mailBox;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<Mail> unreadMails = mailBox.unreadMails();
		System.out.println("Unread emails");
		for (Mail mail : unreadMails) {
			System.out.println(mail);
		}
		System.out.println("Fin unread emails");
	}

}
