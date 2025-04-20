package com.esisa.dp.behavioral.command.mailbox;

import java.util.List;

public class MailBoxExamples {
	public static void main(String[] args) {
		MailBox mailBox = new MailBox();
		exemple1();
		example3(mailBox);
	    example4();
	    example5();
	}
	private static void exemple1() {
		// TODO Auto-generated method stub
		MailBox mailBox = new MailBox();
		
		System.out.println("Exemple 1");
		Command newMailCommand = new SingletonNewMailCommand();
		Invoker invoker1 = new Invoker(newMailCommand, true);
		invoker1.start();
		
		try {
			Thread.sleep(20000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Exemple 2");
		Command[] commands = {
				new SingletonGetInboxCommand(),
				new SingletonLastMailCommand(),
				new SingletonReadMailCommand(mailBox),
				new SingletonDeleteMailCommand(mailBox),
				new UnreadMailsCommand(mailBox)
		};
		
		for(int i = 0; i < commands.length; i++) {
			Invoker invoker2 = new Invoker(commands[i], false);
			invoker2.start();
			try {
				invoker2.join();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		invoker1.interrupt();
	}
	
	private static void example3 (MailBox mailBox) {
		System.out.println("Example 3");
		Command readCommand = new SingletonReadMailCommand(mailBox);
		Command deleteCommand = new SingletonDeleteMailCommand(mailBox);
		Command unreCommand = new UnreadMailsCommand(mailBox);
		
		SingletonMacroCommand macroCommand = new SingletonMacroCommand(readCommand, deleteCommand, unreCommand);
		Invoker invoker = new Invoker(macroCommand, false);
		invoker.start();
		
		try {
			invoker.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void example4() {
		System.out.println("Example 4");
		
		MailBoxSecurityProxy proxy = new MailBoxSecurityProxy("admin", "password");
		
		try {
			proxy.getInbox();
		}catch (SecurityException e){
			System.out.println("Expected exception: " + e.getMessage());
		}
		
		proxy.authenticate("admin", "password");
		
		for (int i=0; i<5; i++) {
			char fromLetter = (char) ('a' + i);
			Mail mail = new Mail(
				fromLetter + "@gmail.com",
				"Subject " + i,
				"Content" + (1000 + i)
			);
			proxy.newMail(mail);
		}
		
		List<Mail> inbox = proxy.getInbox();
	    System.out.println("=== All Emails via Proxy ===");
	    for (int i = 0; i < inbox.size(); i++) {
	        Mail mail = inbox.get(i);
	        System.out.println(mail);
	    }
	    System.out.println("=== End of Inbox ===");
	    
	    // Try with invalid credentials
	    proxy = new MailBoxSecurityProxy("admin", "password");
	    boolean success = proxy.authenticate("admin", "wrongpassword");
	    System.out.println("Authentication success: " + success);
	    
	    try {
	        proxy.getInbox();
	    } catch (SecurityException e) {
	        System.out.println("Expected exception: " + e.getMessage());
	    }
	}
	
	private static void example5() {
	    System.out.println("\n=== Example 5: Singleton MailBox ===");
	    
	    // Create commands using the singleton
	    Command newMailCommand = new SingletonNewMailCommand();
	    Command getInboxCommand = new SingletonGetInboxCommand();
	    
	    // Use the same invoker pattern as before
	    Invoker invoker1 = new Invoker(newMailCommand, true);
	    invoker1.start();
	    
	    try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    Invoker invoker2 = new Invoker(getInboxCommand, false);
	    invoker2.start();
	    
	    try {
	        invoker2.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    invoker1.interrupt();
	}
}
