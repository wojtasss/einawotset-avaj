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
	
	public void addInt(Integer x) {
		if(x == null) {
			throw new NullPointerException();
		} else {
			for(int i=0; i<SIZE ; i++) {
				int hash = H(x, i);
				
				if(array[hash] == null) {
					array[hash] = new Integer(x);
					break;
				} else {
					if(i == SIZE-1) {
						throw new FullArrayException();
					}
				}
			}
		}
	}
	
	public void delInt(Integer x) {
		if(x == null) {
			throw new NullPointerException();
		} else {
			if(array[H(x, 0)] != null) {
				for(int i=0; i<SIZE; i++) {
					int hash = H(x, i);
					
					if(array[hash] == x) {
						array[hash] = null;
						return;
					} else {
						if(i == SIZE-1) {
							throw new NotFoundException();
						}
					}
				}
			} else {
				throw new NotFoundException();
			}
		}
	}
	
	public boolean searchInt(Integer x) {
		if(x == null) {
			throw new NullPointerException();
		} else {
			if(array[H(x,0)] != null) {
				for(int i=0; ; i++) {
					if(array[H(x,i)] == x) {
						return true;
					} else {
						if(i == SIZE-1) {
							return false;
						}
					}
				}
			} else {
				return false;
			}
		}
	}
	
	private Integer h(Integer x) {
		return (x % P) % SIZE;
	}
	
	private Integer H(Integer x, Integer k) {
		return (h(x) + k) % SIZE;
	}
}
