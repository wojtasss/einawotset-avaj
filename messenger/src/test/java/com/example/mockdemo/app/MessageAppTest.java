package com.example.mockdemo.app;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
	
	
	@After
	public void tearDown() throws Exception {
		messenger = null;
		msmock = null;
	}
}
