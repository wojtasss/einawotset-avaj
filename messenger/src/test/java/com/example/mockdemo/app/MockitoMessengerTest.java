package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MockitoMessengerTest {
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER_1 = "inf.ug.edu.eu";
	private final String INVALID_SERVER_2 = "test";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	private Messenger messenger;
	@Mock MessageService msmock;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		messenger = new Messenger(msmock);
	}

	@Test
	public void CheckConnectionServerNameNull() {
		when(msmock.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(0, messenger.testConnection(null));
		verify(msmock).checkConnection(null);
	}
	
	@Test
	public void CheckConnectionServerNameValid() {
		when(msmock.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
		verify(msmock).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void CheckConnectionServerNameDoNotEndsWithPL() {
		when(msmock.checkConnection(INVALID_SERVER_1)).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(1, messenger.testConnection(INVALID_SERVER_1));
		verify(msmock).checkConnection(INVALID_SERVER_1);
	}
	
	@Test
	public void CheckConnectionServerNameValidError() {
		when(msmock.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(msmock).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void SendServerNullMessageNull() throws MalformedRecipientException {
		when(msmock.send(null, null)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(null, null));
		verify(msmock).send(null, null);
	}
	
	@Test
	public void SendServerValidMessageNull() throws MalformedRecipientException {
		when(msmock.send(VALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
		verify(msmock).send(VALID_SERVER, null);
	}
	
	@Test
	public void SendServerNameToShortMessageValid() throws MalformedRecipientException {
		when(msmock.send(INVALID_SERVER_2, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, VALID_MESSAGE));
		verify(msmock).send(INVALID_SERVER_2, VALID_MESSAGE);
	}
	
	@Test
	public void SendServerNameToShortMessageInvalid() throws MalformedRecipientException {
		when(msmock.send(INVALID_SERVER_2, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, INVALID_MESSAGE));
		verify(msmock).send(INVALID_SERVER_2, INVALID_MESSAGE);
	}
	
	@Test
	public void SendServerNameToShortMessageNull() throws MalformedRecipientException {
		when(msmock.send(INVALID_SERVER_2, null)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, null));
		verify(msmock).send(INVALID_SERVER_2, null);
	}
	
	@Test
	public void SendServerNullMessageValid() throws MalformedRecipientException {
		when(msmock.send(null, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
		verify(msmock).send(null, VALID_MESSAGE);
	}
	
	@Test
	public void SendServerValidMessageInvalid() throws MalformedRecipientException {
		when(msmock.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
		verify(msmock).send(VALID_SERVER, INVALID_MESSAGE);
	}
	
	@Test
	public void SendServerValidMessageValid() throws MalformedRecipientException {
		when(msmock.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		verify(msmock).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void SendServerValidMessageValidError() throws MalformedRecipientException {
		when(msmock.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		verify(msmock).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@After
	public void tearDown() throws Exception {
		messenger = null;
		msmock = null;
	}

}
