package org.junit.kolokwium.exc2.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;
import org.junit.kolokwium.exc2.exception.DivisorEqualsZeroException;
import org.junit.kolokwium.exc2.exception.NegativeNumberException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KontraktTititExceptionTest {

	private Kontrakt kontrakt;
	private ArrayList<Integer> data;
	private Object expected;
	
	public KontraktTititExceptionTest(ArrayList<Integer> data, Object expected) {
		this.data = data;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{new ArrayList<Integer>() {{ add(1234); add(0); }}, null},
                	{new ArrayList<Integer>() {{ add(767); add(0); }}, null},
                	{new ArrayList<Integer>() {{ add(-23434); add(0); }}, null}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		try {
			kontrakt.Titit(data.get(0), data.get(1));
		} catch(DivisorEqualsZeroException ex) {
			assertTrue(true);
		}
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
