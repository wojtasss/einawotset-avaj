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
public class KontraktHultajChochlaCorrectFirstCaseTest {

	private Kontrakt kontrakt;
	private int data;
	private ArrayList<Integer> expected;
	
	public KontraktHultajChochlaCorrectFirstCaseTest(int data, ArrayList<Integer> expected) {
		this.data = data;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{123, 
                		new ArrayList<Integer>() {{ add(213); add(321); add(132); add(312); }}},
                	{-789,
                		new ArrayList<Integer>() {{ add(-879); add(-987); add(-798); add(-978); }}},
                	{415,
                		new ArrayList<Integer>() {{ add(145); add(541); add(451); add(514); }}}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		int result = kontrakt.HultajChochla(data);
		assertThat(result, either(is(expected.get(0))).or(is(expected.get(1))).or(is(expected.get(2))).or(is(expected.get(3))));
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}

}
