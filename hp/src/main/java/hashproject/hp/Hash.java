package hashproject.hp;

import org.apache.commons.lang.NullArgumentException;

import hashproject.exception.FullArrayException;
import hashproject.exception.NotFoundException;

public class Hash {
	private final int SIZE = 10;
	private final int P = 13;
	private Integer array[];
	
	public Hash() {
		array = new Integer[SIZE];
	}
	
	public boolean addInt(Integer x) {
		if(x == null) {
			throw new NullPointerException();
		} else {
			for(int i=0; i<SIZE ; i++) {
				int hash = H(x, i);
				
				if(array[hash] == null) {
					array[hash] = new Integer(x);
					return true;
				}
			}
			throw new FullArrayException();
		}
	}
	
	public boolean delInt(Integer x) {
		if(x == null) {
			throw new NullPointerException();
		} else {
			for(int i=0; i<SIZE; i++) {
				if(array[H(x, i)] != null) {
					int hash = H(x, i);
						
					if(array[hash].equals(x)) {
						array[hash] = null;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean searchInt(Integer x) {
		if(x == null) {
			throw new NullPointerException();
		} else {
			for(int i=0; i<SIZE; i++) {
				if(array[H(x,i)] != null) {
					if(array[H(x,i)].equals(x)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private Integer h(Integer x) {
		return (x % P) % SIZE;
	}
	
	private Integer H(Integer x, Integer k) {
		return (h(x) + k) % SIZE;
	}
}
