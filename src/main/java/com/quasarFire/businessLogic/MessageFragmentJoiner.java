package com.quasarFire.businessLogic;

import java.util.LinkedList;
import java.util.List;

import com.quasarFire.businessLogic.exception.IncompleteMessageException;

public class MessageFragmentJoiner {
	
	public static String join(String[]... fragments) throws IncompleteMessageException{
		List<String> finalMessage = new LinkedList<String>();
		for(int sentence=0; sentence < fragments.length && finalMessage.size() < fragments[0].length ; sentence++) {
			for(int word=0; word < fragments[sentence].length ; word++) {
				
				if(fragments[sentence][word].isEmpty()) {
					sentence++;

					if(sentence == fragments.length) {
						throw new IncompleteMessageException("No se ha podido decifrar el mensaje completo.");
					}
					
					
					word--;
					continue;
				}

				finalMessage.add(fragments[sentence][word]);
				sentence = 0;
			}
		}
		return String.join(" ",finalMessage);
	}

}
