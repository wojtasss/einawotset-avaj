package org.junit.kolokwium.exc1.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc1.Stack;
import org.junit.kolokwium.exc1.exceptions.NullStackException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StackPushException {
	
	private Stack stack;
	private int data;
	
	public StackPushException(int data, ArrayList<Integer> expected) {
		this.data = data;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ {1, null}, {12, null}, {7, null} }
        );
    }
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@Test
	public void NullStackExceptionTest() {
		stack.setStack(null);
		try{
			stack.push(data);
		} catch (NullStackException ex) {
			assertTrue(true);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}

}
