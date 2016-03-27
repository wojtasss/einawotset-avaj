package com.example.mockdemo.app;

import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	public int testConnection(String server) {
		switch (ms.checkConnection(server)) {
			case SUCCESS:
				return 1;
			default:
				return 0;
			}
	}

	public int sendMessage(String server, String message) {
		try {
			SendingStatus sStatus = ms.send(server, message);
			if(sStatus.equals(SendingStatus.SENT)) {
				return 0;
			} else {
				return 1;
			}
		} catch (MalformedRecipientException e) {
			return 2;
		}
	}
}
