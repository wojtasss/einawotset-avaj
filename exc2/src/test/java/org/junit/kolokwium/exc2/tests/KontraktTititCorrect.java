package org.junit.kolokwium.exc2.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KontraktTititCorrect {

	private Kontrakt kontrakt;
	private ArrayList<Integer> data;
	private boolean expected;
	
	public KontraktTititCorrect(ArrayList<Integer> data, boolean expected) {
		this.data = data;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{new ArrayList<Integer>() {{ add(123); add(8); }}, 
                		false},
                	{new ArrayList<Integer>() {{ add(-34555); add(5); }},
                		true},
                	{new ArrayList<Integer>() {{ add(1000); add(10); }},
                		true}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		boolean result = kontrakt.Titit(data.get(0), data.get(1));
		assertThat(result, is(expected));
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
