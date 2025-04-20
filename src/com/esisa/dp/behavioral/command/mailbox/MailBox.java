package com.esisa.dp.behavioral.command.mailbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MailBox implements MailBoxSubject{
    private List<Mail> mails;

    public MailBox() {
        mails = new Vector<Mail>();
    }

    public void newMail(Mail mail) {
        mails.add(mail);
        System.out.println("New mail added: " + mail);
    }

    public List<Mail> getInbox() {
        return new Vector<Mail>(mails);
    }

    public Mail lastMail() {
        if (mails.isEmpty()) {
            return null;
        }
        return mails.get(mails.size() - 1);
    }

    public void readMail(int id) {
        for (Mail mail : mails) {
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

    public List<Mail> unreadMails() {
        List<Mail> unread = new Vector<Mail>();
        for (Mail mail : mails) {
            if (!mail.isRead()) {
                unread.add(mail);
            }
        }
        return unread;
    }

}