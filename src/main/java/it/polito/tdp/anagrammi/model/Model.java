package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	Set<String> anagrammi;
	AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	public Set<String> calcolaAnagrammi(String parola) {
		 anagrammi = new HashSet<String>();
		 String parziale = "";
		 calcola(parziale, 0, parola, anagrammi);
		 return anagrammi;
	}
	
	private void calcola(String parziale, int livello, String parola, Set<String> anagrammi) {
		//caso terminale
		if(livello == parola.length()) {
			anagrammi.add(parziale);
			return;
		}
		
		for(int i=0; i<parola.length(); i++) {
			if(charCount(parziale, parola.charAt(i)) < charCount(parola, parola.charAt(i))) {
				parziale += parola.charAt(i);
				calcola(parziale, livello+1, parola, anagrammi);
				parziale = parziale.substring(0, parziale.length()-1);
			}
		}
	}
	
	private int charCount(String s, char c) {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == c) {
				count ++;
			}
		}
		return count;
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDAO.isCorrect(anagramma);
	}

}
