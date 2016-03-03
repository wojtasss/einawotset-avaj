package org.junit.kolokwium.exc2.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;

public class KontraktCyfroKradCorrectTest {
	
	private Kontrakt kontrakt;
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}
	
	@Test
	public void test() {
		
	}

	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
