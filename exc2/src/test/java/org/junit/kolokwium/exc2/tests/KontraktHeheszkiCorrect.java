package org.junit.kolokwium.exc2.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KontraktHeheszkiCorrect {
	
	private Kontrakt kontrakt;
	private int data;
	private Integer expected;
	
	public KontraktHeheszkiCorrect(int data, Integer expected) {
		this.data = data;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, null},
                	{789, null},
                	{415, null}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		int result = kontrakt.Heheszki(data);
		assertThat(result, is(both(greaterThanOrEqualTo(0)).and(lessThan(data))));
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
