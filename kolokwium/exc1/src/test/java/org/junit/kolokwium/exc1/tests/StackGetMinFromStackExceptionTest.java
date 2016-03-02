package org.junit.kolokwium.exc1.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc1.Stack;
import org.junit.kolokwium.exc1.exceptions.EmptyStackException;
import org.junit.kolokwium.exc1.exceptions.NullStackException;

public class StackGetMinFromStackExceptionTest {
	
	private Stack stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@Test
	public void NullStackExceptionTest() {
		stack.setStack(null);
		try {
			stack.getMinFromStack();
		} catch (NullStackException ex) {
			assertTrue(true);
		}
	}
	
	@Test
	public void EmptyStackExceptionTest() {
		stack.setStack(new ArrayList<Integer>());
		try {
			stack.getMinFromStack();
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}
}
