package com.example.mockdemo.app;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockMessengerTest {

	private Messenger messenger;
	private MessageService msmock;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER_1 = "inf.ug.edu.eu";
	private final String INVALID_SERVER_2 = "test";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		msmock = mock(MessageService.class);
		messenger = new Messenger(msmock);
	}
	
	@Test
	public void CheckConnectionServerNameNull() {
		expect(msmock.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		replay(msmock);
		assertEquals(0, messenger.testConnection(null));
	}
	
	@Test
	public void CheckConnectionServerNameValid() {
		expect(msmock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		replay(msmock);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void CheckConnectionServerNameDoNotEndsWithPL() {
		expect(msmock.checkConnection(INVALID_SERVER_1)).andReturn(ConnectionStatus.SUCCESS);
		replay(msmock);
		assertEquals(1, messenger.testConnection(INVALID_SERVER_1));
	}
	
	@Test
	public void CheckConnectionServerNameValidError() {
		expect(msmock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(msmock);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void SendServerNullMessageNull() throws MalformedRecipientException {
		expect(msmock.send(null, null)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(null, null));
	}
	
	@Test
	public void SendServerValidMessageNull() throws MalformedRecipientException {
		expect(msmock.send(VALID_SERVER, null)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void SendServerNameToShortMessageValid() throws MalformedRecipientException {
		expect(msmock.send(INVALID_SERVER_2, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, VALID_MESSAGE));
	}
	
	@Test
	public void SendServerNameToShortMessageInvalid() throws MalformedRecipientException {
		expect(msmock.send(INVALID_SERVER_2, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, INVALID_MESSAGE));
	}
	
	@Test
	public void SendServerNameToShortMessageNull() throws MalformedRecipientException {
		expect(msmock.send(INVALID_SERVER_2, null)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, null));
	}
	
	@Test
	public void SendServerNullMessageValid() throws MalformedRecipientException {
		expect(msmock.send(null, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void SendServerValidMessageInvalid() throws MalformedRecipientException {
		expect(msmock.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msmock);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void SendServerValidMessageValid() throws MalformedRecipientException {
		expect(msmock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		replay(msmock);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void SendServerValidMessageValidError() throws MalformedRecipientException {
		expect(msmock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(msmock);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@After
	public void tearDown() throws Exception {
		msmock = null;
		messenger = null;
	}
}
