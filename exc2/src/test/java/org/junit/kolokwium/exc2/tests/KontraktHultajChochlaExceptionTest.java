package org.junit.kolokwium.exc2.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;
import org.junit.kolokwium.exc2.exception.NieudanyPsikusExcpetion;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KontraktHultajChochlaExceptionTest {

	private Kontrakt kontrakt;
	private int data;
	private Object expected;
	
	public KontraktHultajChochlaExceptionTest(int data, Object expected) {
		this.data = data;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{4, null},
                	{9, null},
                	{-3, null}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		try {
			kontrakt.HultajChochla(data);
		} catch(NieudanyPsikusExcpetion ex) {
			assertTrue(true);
		}
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
