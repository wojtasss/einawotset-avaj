package Tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.emptyCollectionOf;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BubbleSort.BubbleSort;

public class BubbleSortTest {
	
	private BubbleSort bubbleSort;
	
	@Before
	public void setUp() {
		bubbleSort = new BubbleSort();
	}
	
	//podana lista do sortowania jest nullem
	@Test
	public void test01() {
		try {
			bubbleSort.sort(null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	//podana lista do sortowania nie jest null
	//i zawiera jeden element
	@Test
	public void test02() {
		bubbleSort.sort(new ArrayList<Integer>() {
			{
				add(1);
			}
		});
		List<Integer> result = bubbleSort.getSortedList();
		List<Integer> expected = new ArrayList<Integer>() {
			{
				add(1);
			}
		};
		assertThat(result, equalTo(expected));
	}
	
	//podana lista do sortowania nie jest null
	//i nie zawiera elementow
	@Test
	public void test03() {
		bubbleSort.sort(new ArrayList<Integer>());
		List<Integer> result = bubbleSort.getSortedList();
		assertThat(result, emptyCollectionOf(Integer.class));
	}
	
	//podana lista do sortowania nie jest null
	//i zawiera wiecej niz jeden element
	@Test
	public void test04() {
		bubbleSort.sort(new ArrayList<Integer>() {
			{
				add(5);
				add(3);
				add(1);
			}
		});
		List<Integer> result = bubbleSort.getSortedList();
		List<Integer> expected = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
				add(5);
			}
		};
		assertThat(result, equalTo(expected));
	}
	
	@After
	public void tearDown() {
		bubbleSort = null;
	}

}
