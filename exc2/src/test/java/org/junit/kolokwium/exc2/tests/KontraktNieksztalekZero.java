package org.junit.kolokwium.exc2.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;

public class KontraktNieksztalekZero {
	
	private Kontrakt kontrakt;
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}
	
	@Test
	public void test() {
		Integer result = kontrakt.Nieksztalek(0);
		assertThat(result, is(0));
	}

	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
