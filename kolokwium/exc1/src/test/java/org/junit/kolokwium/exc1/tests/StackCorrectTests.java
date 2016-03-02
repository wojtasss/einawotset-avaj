package org.junit.kolokwium.exc1.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.kolokwium.exc1.Stack;

public class StackCorrectTests {
	
	private Stack stack = null;
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}

}
