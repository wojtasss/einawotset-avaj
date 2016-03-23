package com.example.mockdemo.app;

import java.util.Random;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageServiceMock implements MessageService {

	@Override
	public ConnectionStatus checkConnection(String server) {
		if (!server.endsWith(".pl")) {
			return ConnectionStatus.FAILURE;
		}
		return ConnectionStatus.SUCCESS;
	}

	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		if (message == null || message.length() < 3 || server == null || server.length() < 4) {
			throw new MalformedRecipientException();
		} else if (checkConnection(server) == ConnectionStatus.FAILURE) {
			return SendingStatus.SENDING_ERROR;
		} else {
			if ((new Random()).nextBoolean()) {
				return SendingStatus.SENT;
			}
			return SendingStatus.SENDING_ERROR;
		}
	}

}
