package org.junit.kolokwium.exc2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.kolokwium.exc2.exception.NieudanyPsikusExcpetion;
import org.junit.kolokwium.exc2.interfaces.Psikus;

public class Kontrakt implements Psikus {
	
	private Random random = new Random();
	
	public Integer CyfroKrad(Integer liczba) {
		String sNumber;
		StringBuilder bString;
		
		if(liczba < 9 && liczba > -9) {
			return null;
		} else if(liczba > 10){
			sNumber = liczba.toString();
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(random.nextInt(sNumber.length()));
			
			return Integer.parseInt(bString.toString());
		} else {
			sNumber = liczba.toString();
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(random.nextInt(sNumber.length()-1)+1);
			
			return Integer.parseInt(bString.toString());
		}
	}

	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusExcpetion {
		String sNumber;
		StringBuilder bString;
		
		if(liczba > -10 && liczba < 10) {
			throw new NieudanyPsikusExcpetion();
		} else if(liczba < 99 && liczba > 9) {
			sNumber = liczba.toString();
			bString = new StringBuilder(sNumber);
			bString.reverse();
			
			return Integer.parseInt(bString.toString());	
		} else if(liczba > -99 && liczba < -9) {
			sNumber = liczba.toString();
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(0);
			bString.reverse();
			bString.insert(0, "-");
			
			return Integer.parseInt(bString.toString());
		} else if (liczba > 99) {			
			sNumber = liczba.toString();
			bString = new StringBuilder(sNumber);
			bString = replaceNumbers(bString, sNumber);
			
			return Integer.parseInt(bString.toString());
		} else {
			sNumber = liczba.toString();
			bString = new StringBuilder(sNumber);
			bString.deleteCharAt(0);
			bString = replaceNumbers(bString, sNumber);
			bString.insert(0, '-');
			
			return Integer.parseInt(bString.toString());
		}
	}

	public Integer Nieksztalek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer Heheszki(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Titit(Integer liczba_dziel) {
		// TODO Auto-generated method stub
		return false;
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

}
