package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageAppTest {

	Messenger messenger;
	MessageServiceMock msmock;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER_1 = "inf.ug.edu.eu";
	private final String INVALID_SERVER_2 = "test";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		msmock = new MessageServiceMock();
		messenger = new Messenger(msmock);
	}
	
	@Test
	public void CheckConnectionServerIsNull() {
		assertEquals(0, messenger.testConnection(null));
	}
	
	@Test
	public void CheckConnectionStringIsInvalid() {
		assertEquals(0, messenger.testConnection(INVALID_SERVER_2));
	}
	
	@Test
	public void CheckConnectionStringDoNotEndsWithPL() {
		assertEquals(0, messenger.testConnection(INVALID_SERVER_1));
	}

	@Test
	public void CheckConnectionStringIsValid() {
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void SendServerNullMessageValid() {
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void SendServerValidMessageNull() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void SendServerInvalidNameMessageValid() {
		assertEquals(1, messenger.sendMessage(INVALID_SERVER_1, VALID_MESSAGE));
	}
	
	@Test 
	public void SendServerShortName() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_1, null));
	}
	
	@Test
	public void SendMessageNull() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void SendMessageToShort() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void SendServerAndMessageValid() {
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE), either(equalTo(0)).or(equalTo(1)));
	}
	
	@After
	public void tearDown() throws Exception {
		messenger = null;
		msmock = null;
	}
}
