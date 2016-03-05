package org.junit.kolokwium.exc2.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.either;
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
public class KontraktCyfroKradCorrect {
	
	private Kontrakt kontrakt;
	private int data;
	private ArrayList<Integer> expected;
	
	public KontraktCyfroKradCorrect(int data, ArrayList<Integer> expected) {
		this.data = data;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, 
                		new ArrayList<Integer>() {{ add(12); add(23); add(13); }}},
                	{-789,
                		new ArrayList<Integer>() {{ add(-89); add(-78); add(-79); }}},
                	{415,
                		new ArrayList<Integer>() {{ add(15); add(41); add(45);  }}}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		int result = kontrakt.CyfroKrad(data);
		assertThat(result, either(is(expected.get(0))).or(is(expected.get(1))).or(is(expected.get(2))));
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
