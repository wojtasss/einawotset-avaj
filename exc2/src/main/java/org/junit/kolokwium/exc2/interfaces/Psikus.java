package org.junit.kolokwium.exc2.interfaces;

import org.junit.kolokwium.exc2.exception.NieudanyPsikusExcpetion;

public interface Psikus {
	public Integer CyfroKrad(Integer liczba);
	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusExcpetion;
	public Integer Nieksztalek(Integer liczba);
	public Integer Heheszki(Integer liczba);
	boolean Titit(Integer liczba, Integer liczba_dziel);
}
