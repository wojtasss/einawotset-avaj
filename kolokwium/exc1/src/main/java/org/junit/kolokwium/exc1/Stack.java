package org.junit.kolokwium.exc1;

import java.util.ArrayList;
import java.util.List;

import org.junit.kolokwium.exc1.exceptions.EmptyStackException;
import org.junit.kolokwium.exc1.exceptions.NullStackException;
import org.junit.kolokwium.exc1.interfaces.Stackable;

public class Stack implements Stackable {

	private List<Integer> stack = new ArrayList<Integer>();
	
	public void push(int e) {
		if(stack == null) {
			throw new NullStackException();
		} else {
			stack.add(0, e);
		}
	}

	public int pop() {
		if(stack == null) {
			throw new NullStackException();
		} else if(stack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return stack.remove(0);
		}
	}

	public boolean isNull() {
		if(stack == null) {
			return true;
		} else {
			return false;
		}
	}

	public int top() {
		// TODO Auto-generated method stub
		return 0;
	}

}
