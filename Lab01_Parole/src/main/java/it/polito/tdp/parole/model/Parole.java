package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	LinkedList <String> parole;
		
	public Parole() {
		parole = new LinkedList <String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		
		Collections.sort(parole, new ComparatoreParoleOrdineAlfabetico());
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void removeParola(String s) {
		
		parole.remove(s);
			
		
	}

}
