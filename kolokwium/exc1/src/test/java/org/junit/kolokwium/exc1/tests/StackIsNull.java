package org.junit.kolokwium.exc1.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc1.Stack;

public class StackIsNull {
	
	private Stack stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}
	
	@Test
	public void StackIsNullTest() {
		stack.setStack(null);
		boolean result = stack.isNull();
		assertTrue(result);
	}
	
	@Test
	public void StackIsNotNullTest() {
		stack.setStack(new ArrayList<Integer>());
		boolean result = stack.isNull();
		assertFalse(result);
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}
}
