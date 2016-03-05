package org.junit.kolokwium.exc2.tests;

import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.kolokwium.exc2.Kontrakt;

public class KontraktCyfroKradNull {
	
	private Kontrakt kontrakt;
	
	@Before
	public void setUp() throws Exception {
		kontrakt = new Kontrakt();
	}
	
	@Test
	public void test() {
		Integer result = kontrakt.CyfroKrad(0);
		assertThat(result, nullValue());
	}

	@After
	public void tearDown() throws Exception {
		kontrakt = null;
	}
}
