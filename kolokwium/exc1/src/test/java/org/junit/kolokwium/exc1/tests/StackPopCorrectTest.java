package org.junit.kolokwium.exc1.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc1.Stack;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StackPopCorrectTest {
	
	private Stack stack;
	private ArrayList<Integer> data;
	private int expected;
	
	public StackPopCorrectTest(ArrayList<Integer> data, int expected) {
		this.data = data;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{new ArrayList<Integer>() {{add(0, 1); }}, 1},
                	{new ArrayList<Integer>() {{add(0, 1); add(0, 2); }}, 2},
                	{new ArrayList<Integer>() {{add(0, 1); add(0, 2); add(0, 3); }}, 3}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
	}

	@Test
	public void test() {
		stack.setStack(data);
		int result = stack.pop();
		assertEquals(expected, result);
	}
	
	@After
	public void tearDown() throws Exception {
		stack = null;
	}
}
