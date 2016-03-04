package org.junit.kolokwium.exc2;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.kolokwium.exc2.exception.DivisorEqualsZeroException;
import org.junit.kolokwium.exc2.exception.NegativeNumberException;
import org.junit.kolokwium.exc2.exception.NieudanyPsikusExcpetion;
import org.junit.kolokwium.exc2.interfaces.Psikus;

public class Kontrakt implements Psikus {
	
	private Random random = new Random();
	
	public Integer CyfroKrad(Integer liczba) {
		String sNumber = liczba.toString();
		StringBuilder bString;
		
		if(liczba < 9 && liczba > -9) {
			return null;
		} else if(liczba > 10){
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(random.nextInt(sNumber.length()));
			
			return Integer.parseInt(bString.toString());
		} else {
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(random.nextInt(sNumber.length()-1)+1);
			
			return Integer.parseInt(bString.toString());
		}
	}

	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusExcpetion {
		String sNumber = liczba.toString();
		StringBuilder bString;
		
		if(liczba > -10 && liczba < 10) {
			throw new NieudanyPsikusExcpetion();
		} else if(liczba < 99 && liczba > 9) {
			bString = new StringBuilder(sNumber);
			bString.reverse();
			
			return Integer.parseInt(bString.toString());	
		} else if(liczba > -99 && liczba < -9) {
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(0);
			bString.reverse();
			bString.insert(0, "-");
			
			return Integer.parseInt(bString.toString());
		} else if (liczba > 99) {			
			bString = new StringBuilder(sNumber);
			bString = replaceNumbers(bString, sNumber);
			
			return Integer.parseInt(bString.toString());
		} else {
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(0);
			bString = replaceNumbers(bString, sNumber);
			bString.insert(0, '-');
			
			return Integer.parseInt(bString.toString());
		}
	}

	public Integer Nieksztalek(Integer liczba) {
		String sNumber = liczba.toString();
		StringBuilder bString;
		
		if(liczba > 0) {
			bString = new StringBuilder(sNumber);
			bString = patternMapNumber(bString);
			
			return Integer.parseInt(bString.toString());
		} else if(liczba < 0) {
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(0);
			bString = patternMapNumber(bString);
			bString.insert(0, '-');
			
			return Integer.parseInt(bString.toString());
		} else {
			return 0;
		}
	}

	public Integer Heheszki(Integer liczba) {
		if (liczba < 0) {
			throw new NegativeNumberException();
		} else if (liczba == 0) {
			return 0;
		} else {
			return random.nextInt(liczba);
		}
	}

	public boolean Titit(Integer liczba, Integer liczba_dziel) {
		if(liczba_dziel == 0) {
			throw new DivisorEqualsZeroException();
		} else {
			if(liczba % liczba_dziel == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private StringBuilder replaceNumbers(StringBuilder bString, String sNumber) {
		HashMap<Integer, Character> randomNumbers = new HashMap<Integer, Character>();
		int rNumber;
		
		rNumber = random.nextInt(sNumber.length());
		randomNumbers.put(rNumber, bString.charAt(rNumber));
		bString.deleteCharAt(rNumber);
		rNumber = random.nextInt(sNumber.length());
		randomNumbers.put(rNumber, bString.charAt(rNumber));
		bString = new StringBuilder(sNumber);
		
		for (Map.Entry<Integer, Character> e : randomNumbers.entrySet()) {
		    bString.replace(e.getKey(), e.getKey(), e.getValue().toString());
		}
		
		return bString;
	}
	
	private StringBuilder patternMapNumber(StringBuilder bString) {
		HashMap<Integer, Character> pattern = new HashMap<Integer, Character>() {{
			put(3, '8');
			put(7, '1');
			put(6, '9');
		}};
		ArrayList<Integer> numbersToFind = new ArrayList<Integer>() {{
			add(3);
			add(7);
			add(6);
		}};
		boolean endLoop = false;
		int firstFindNumber = 0;
		
		for(int i=3; i>0; i--) {
			int randomKey = numbersToFind.get(new Integer(random.nextInt(i)));
			
		    for(Character ch : bString.toString().toCharArray()) {
		    	if(ch.equals(pattern.get(randomKey))) {
		    		endLoop = true;
		    		firstFindNumber = pattern.get(randomKey);
		    		break;
		    	}
		    } 
		    if(!endLoop) {
		    	numbersToFind.remove(new Integer(randomKey));
		    } else {
		    	break;
		    }
		}
		
		if(firstFindNumber == 0) {
			return bString;
		} else {
			int index = 0;
			
			for (Character ch : bString.toString().toCharArray()) {
			   if(ch.equals(firstFindNumber)) {
				   bString.replace(index, index, pattern.get(firstFindNumber).toString());
			   }
			   index++;
			}
			return bString;
		}
	}
}
