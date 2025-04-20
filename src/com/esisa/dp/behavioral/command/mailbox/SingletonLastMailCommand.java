package com.esisa.dp.behavioral.command.mailbox;

public class SingletonLastMailCommand implements Command{

//	private MailBox mailBox;
//	
//	public LastMailCommand(MailBox mailBox) {
//		this.mailBox = mailBox;
//	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Mail lastMail = MailBoxSingleton.getInstance().lastMail();
		if (lastMail != null) {
			System.out.println("Last mail :" + lastMail);
		}else {
			System.out.println("No mails in inbox");
		}
	}
}
