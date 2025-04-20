package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;

public interface MailBoxSubject {
	void newMail(Mail mail);
	List<Mail> getInbox();
	Mail lastMail();
	void readMail(int id);
	Mail deleteMail(int id);
	List<Mail> unreadMails();
}
