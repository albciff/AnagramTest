package cat.test.anagram.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verse {

	private List<Line> lines = new ArrayList<>();
	
	public boolean addLine(Line l){
		return lines.add(l);
	}
	
	public List<Line> getLines(){
		return lines;
	}
	
	private List<Character> getAllLines(){
		List<Character> allLines = new ArrayList<Character>();
		for(Line l : lines){
			allLines.addAll(l.getContent());
		}
		
		return allLines;
	}
	
	
	
	public boolean isAnagram(Verse v){
		
		List<Character> verseContent = this.getAllLines();
		List<Character> verseContentToCompare = v.getAllLines();
		
		boolean isAnagram = false;
		
		// comprovem la mida, per evitar que una sigui un superset
		// de l'altre... si ja no coincideixen descartem
		if(verseContent.size()==verseContentToCompare.size()){
			// només considerem anagrama si conte els mateixos caràcters,
			// però no en el mateix ordre! (és a dir exactament el mateix
			// verse sense canviar l'ordre de cap lletra no es considera anagrama
			isAnagram = verseContent.containsAll(verseContentToCompare) && 
					!Arrays.equals(verseContent.toArray(),verseContentToCompare.toArray());
		}
		
		return isAnagram;
	}
}
