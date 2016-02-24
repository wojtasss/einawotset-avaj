import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Calculator.Calculator;

public class CalculatorTest {
	
	private Calculator calc;
	
	@Before
	public void setUp() {
		calc = new Calculator();
	}
	
	//testowanie dodawania
	@Test
	public void test01() {
		int result = calc.add(12, 5);
		assertThat(result, equalTo(17));
	}
	
	//testowanie odejmowania
	@Test
	public void test02() {
		int result = calc.sub(10, 4);
		assertThat(result, equalTo(6));
	}
	
	//testowanie mnozenia
	@Test
	public void test03() {
		int result = calc.multi(12, 12);
		assertThat(result, equalTo(144));
	}
	
	//tesotawnie dzielenia gdy dzielnik jest rowny 0
	@Test
	public void test04() {
		try {
			int result = calc.div(4, 0);
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
		}
	}
	
	//tesotawnie dzielenia gdy dzielnik jest rozny od 0
	@Test
	public void test05() {
		int result = calc.div(4, 2);
		assertThat(result, equalTo(2));
	}
	
	//testowanie greater gdy a wieksze od b
	@Test
	public void test06() {
		boolean result = calc.greater(12, 5);
		assertThat(result, equalTo(true));
	}
	
	//testowanie greater gdy a mniejsze od b
	@Test
	public void test07() {
		boolean result = calc.greater(4, 12);
		assertThat(result, equalTo(false));
	}
	
	@After
	public void tearDown() {
		calc = null;
	}

}
