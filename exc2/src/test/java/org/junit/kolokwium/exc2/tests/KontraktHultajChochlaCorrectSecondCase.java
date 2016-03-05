package org.junit.kolokwium.exc2.tests;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KontraktHultajChochlaCorrectSecondCase {

	private Kontrakt kontrakt;
	private int data;
	private int expected;
	
	public KontraktHultajChochlaCorrectSecondCase(int data, int expected) {
		this.data = data;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{-12, -21},
                	{32, 23},
                	{-64, -46}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		int result = kontrakt.HultajChochla(data);
		assertThat(result, is(expected));
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

}
