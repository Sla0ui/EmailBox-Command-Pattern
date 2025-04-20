package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;

public class MailBoxSecurityProxy implements MailBoxSubject{

	private MailBox realMailBox;
	private String username;
	private String password;
	private boolean authenticated;
	
	
	public MailBoxSecurityProxy(String username, String password) {
		super();
		this.realMailBox = new MailBox();
		this.username = username;
		this.password = password;
		this.authenticated = false;
	}
	
	public boolean authenticate(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.authenticated = true;
            System.out.println("Authentication successful");
            return true;
        }
        System.out.println("Authentication failed");
        return false;
    }
	
	private void checkAuthentication() {
        if (!authenticated) {
            throw new SecurityException("Not authenticated");
        }
    }

	@Override
	public void newMail(Mail mail) {
		// TODO Auto-generated method stub
		realMailBox.newMail(mail);
	}

	@Override
	public List<Mail> getInbox() {
		// TODO Auto-generated method stub
		checkAuthentication();
		return realMailBox.getInbox();
	}

	@Override
	public Mail lastMail() {
		// TODO Auto-generated method stub
		checkAuthentication();
		return realMailBox.lastMail();
	}

	@Override
	public void readMail(int id) {
		// TODO Auto-generated method stub
		realMailBox.readMail(id);
	}

	@Override
	public List<Mail> unreadMails() {
		// TODO Auto-generated method stub
		return realMailBox.unreadMails();
	}

	@Override
	public Mail deleteMail(int id) {
		// TODO Auto-generated method stub
		checkAuthentication();
		return realMailBox.deleteMail(id);
	}
	
}
