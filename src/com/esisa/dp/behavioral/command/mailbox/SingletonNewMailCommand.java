package com.esisa.dp.behavioral.command.mailbox;

import java.util.Random;

public class SingletonNewMailCommand implements Command{
//	private MailBox mailBox;
	private Random random;
	
	public SingletonNewMailCommand() {
        this.random = new Random();
    }
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		char fromLetter = (char) ('a' + random.nextInt(26));
		char objectLetter = (char) ('a' + random.nextInt(26));
		int content = 1000 + random.nextInt(9000);
		
		Mail mail = new Mail(
				fromLetter + "@gmail.com",
				String.valueOf(objectLetter),
				String.valueOf(content)
		);
        MailBoxSingleton.getInstance().newMail(mail);
    }
}
