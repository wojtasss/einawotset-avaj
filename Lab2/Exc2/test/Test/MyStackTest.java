package Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import NewStack.MyStack;

public class MyStackTest {
	
	private MyStack stack;
	
	@Before 
	public void setUp() {
		stack = new MyStack();
	}
	
	//stack jest nullem
	@Test
	public void test01() {
		try {
			stack.getStack();
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	//stack nie jest nullem
	@Test
	public void test02() {
		stack.setStack(new ArrayList<Integer>());
		List<Integer> result = stack.getStack();
		assertThat(result, is(notNullValue()));
	}
	
	//dodawanie elementu do stacka gdy stack jest nullem
	@Test
	public void test03() {
		try {
			stack.setStack(null);
			stack.myPush(1);
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	//dodawanie elementu do stacka gdy stack nie jest nullem
	@Test
	public void test04() {
		stack.setStack(new ArrayList<Integer>());
		stack.myPush(1);
		List<Integer> result = stack.getStack();
		assertThat(result, contains(1));
	}
	
	//zdejmowanie ze stosu gdy stack jest nullem
	@Test
	public void test05() {
		try {
			stack.setStack(null);
			stack.myPop();
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	//zdejmowanie ze stosu gdy stack nie jest nullem
	//i stack nie jest pusty
	@Test
	public void test06() {
		stack.setStack(new ArrayList<Integer>() {
			{
				add(0, 2); 
				add(1, 3); 
			}
		});
		int resultPop = stack.myPop();
		List<Integer> resultStack = stack.getStack();
		assertThat(resultPop, is(2));
		assertThat(resultStack, contains(3));
	}
	
	//zdejmowanie ze stosu gdy stack nie jest nullem
	//i stack jest pusty
	@Test
	public void test07() {
		try {
			stack.setStack(new ArrayList<Integer>());
			stack.myPop();
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
		}
	}
	
	//sprwadzenie czy stos jest pusty gdy nie jest pusty
	@Test
	public void test08() {
		stack.setStack(new ArrayList<Integer>());
		boolean result = stack.isNull();
		assertThat(result, is(false));	
	}
	
	//sprwadzenie czy stos jest pusty gdy jest pusty
	@Test
	public void test09() {
		boolean result = stack.isNull();
		assertThat(result, is(true));
		
	}
	
	//wyciaganie pierwszego elementu ze stacku gdy stack jest nullem
	@Test
	public void test10() {
		try {
			stack.setStack(null);
			stack.myTop();
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	//wyciaganie pierwszego elementu gdy stack nie jest nullem
	//i stack jest pusty
	@Test
	public void test11() {
		try {
			stack.setStack(new ArrayList<Integer>());
			stack.myTop();
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
		}
	}
	
	//wyciaganie pierwszego elementu gdy stack nie jest nullem
	//i stack nie jest pusty
	@Test
	public void test12() {
		stack.setStack(new ArrayList<Integer>() {
			{
				add(0, 2);
			}
		});
		int result = stack.myTop();
		assertThat(result, is(2));
	}
	
	@After
	public void tearDown() {
		stack = null;
	}

}
