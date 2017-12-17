package com.exigent.leopard.core;

import java.util.Date;

public class LogItem {

	Date loggedAt;
	String item;
	
	public LogItem() {
		super();
	}

	public LogItem(String item) {
		super();
		loggedAt = new Date();
		this.item = item;
	}
	
}
