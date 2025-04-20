package com.esisa.dp.behavioral.command.mailbox;

import java.util.Date;

public class Mail {

	private static int counter = 0;
	private int id;
	private String from;
	private String object;
	private Date date;
	private String content;
	private boolean read;
	
	public Mail(String from, String object, String content) {
		super();
		this.id = ++counter;
		this.from = from;
		this.object = object;
		this.date = new Date();
		this.content = content;
		this.read = false;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Mail.counter = counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	@Override
	public String toString() {
		return "Mail [id=" + id + ", from=" + from + ", object=" + object + ", date=" + date + ", content=" + content
				+ ", read=" + read + "]";
	}
	
	
}
