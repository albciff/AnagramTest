package cat.test.anagram.beans;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Objecte que representa una linea d'un poema.
 * 
 * @author albciff
 *
 */
public class Line {
	
	List<Character> content = new ArrayList<Character>();
	
	public void setContent(String lineContent){
		
		// TODO: sanity check linecontent?
		
		// normalitzem per separar els caràcters dels accents i altres simbols
		// en lletres (` ´ ¨ ^)
		String normalized = Normalizer.normalize(lineContent, Normalizer.Form.NFD);
		normalized = normalized.replaceAll("[\\p{M}]", "");
		// ens quedem només amb els caracters evitan altres simbols de puntuacio
		normalized = normalized.replaceAll("[^a-zA-Z]", "");
		
		// afegim el caràcters resultants a la llista
		for(char c : normalized.toLowerCase().toCharArray()) {
			  content.add(c);
		}
		
	}
	
	public List<Character> getContent(){
		return content;
	}
	
	public boolean isAnagram(Line line){
		
		boolean isAnagram = false;
		// comprovem la mida, per evitar que una sigui un superset
		// de l'altre... si ja no coincideixen descartem
		if(this.content.size()==line.content.size()){
			// només considerem anagrama si conte els mateixos caràcters,
			// però no en el mateix ordre! (és a dir exactament la mateixa
			// frase sense canviar l'ordre de cap paraula/lletra no es considera anagrama
			isAnagram = this.content.containsAll(line.content) && 
					!Arrays.equals(this.content.toArray(),line.content.toArray());
		}
		
		return isAnagram;
		
	}

}
