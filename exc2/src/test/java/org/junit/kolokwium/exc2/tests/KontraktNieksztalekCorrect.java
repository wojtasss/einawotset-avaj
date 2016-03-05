package org.junit.kolokwium.exc2.tests;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KontraktNieksztalekCorrect {
	
	private Kontrakt kontrakt;
	private int data;
	private ArrayList<Integer> expected;
	
	public KontraktNieksztalekCorrect(int data, ArrayList<Integer> expected) {
		this.data = data;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{ 
                	{1662333, 
                		new ArrayList<Integer>(){{ add(1662888); add(1992333); }}},
                	{-77789333,
                		new ArrayList<Integer>() {{ add(-11189333); add(-77789888); }}},
                	{6667777,
                		new ArrayList<Integer>() {{ add(9997777); add(6661111); }}}
                });
    }
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}

	@Test
	public void test() {
		int result = kontrakt.Nieksztalek(data);
		assertThat(result, either(is(expected.get(0))).or(is(expected.get(1))));
	}

	
	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
