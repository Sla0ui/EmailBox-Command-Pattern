package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;
import java.util.Vector;

public class MailBoxSingleton implements MailBoxSubject {
    private static MailBoxSingleton instance;
    private List<Mail> mails;
    
    private MailBoxSingleton() {
        mails = new Vector<Mail>();
    }
    
    public static synchronized MailBoxSingleton getInstance() {
        if (instance == null) {
            instance = new MailBoxSingleton();
        }
        return instance;
    }
    
    @Override
    public void newMail(Mail mail) {
        mails.add(mail);
        System.out.println("New mail added: " + mail);
    }
    
    @Override
    public List<Mail> getInbox() {
        return new Vector<Mail>(mails);
    }
    
    @Override
    public Mail lastMail() {
        if (mails.isEmpty()) {
            return null;
        }
        return mails.get(mails.size() - 1);
    }
    
    @Override
    public void readMail(int id) {
        for (int i = 0; i < mails.size(); i++) {
            Mail mail = mails.get(i);
            if (mail.getId() == id) {
                mail.setRead(true);
                System.out.println("Mail " + id + " marked as read");
                return;
            }
        }
        System.out.println("Mail " + id + " not found");
    }
    
    public Mail deleteMail(int id) {
        for (int i = 0; i < mails.size(); i++) {
            if (mails.get(i).getId() == id) {
                Mail mail = mails.remove(i);
                System.out.println("Mail " + id + " deleted");
                return mail;
            }
        }
        System.out.println("Mail " + id + " not found");
        return null;
    }
    
    @Override
    public List<Mail> unreadMails() {
        List<Mail> unread = new Vector<Mail>();
        for (int i = 0; i < mails.size(); i++) {
            Mail mail = mails.get(i);
            if (!mail.isRead()) {
                unread.add(mail);
            }
        }
        return unread;
    }

}