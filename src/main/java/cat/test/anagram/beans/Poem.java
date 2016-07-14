package cat.test.anagram.beans;

import java.util.ArrayList;
import java.util.List;

public class Poem {

	private List<Verse> verses = new ArrayList<Verse>();
	
	public boolean addVerse(Verse v){
		// per evitar tractaments d'entrades erronies
		// en cas q durant el parseig dels poemes masses linies
		// en blanc seguides facin crear més d'un vers, si es buit 
		// evitem afegir-lo
		if(!v.getLines().isEmpty()){
			return verses.add(v);	
		}
		return false;
		
	}

	/**
	 * Comprova q els versos siguin anagramas entre ells.
	 * Cas q no comprova les linies.
	 * 
	 * @return
	 */
	public boolean isAnagram(){
		// comprovem si es per verse o per linies
		return isAnagramByVerse() || isAnagramByLines();

	}

	private boolean isAnagramByVerse(){

		if(verses.size() <= 1) return false;

		// si hi ha més d'un vers els comprovem entre ells
		Verse checker = verses.remove(0);
		for(Verse v : verses){
			if(!checker.isAnagram(v)){
				return false;
			}
		}
		
		return true;

	}

	private boolean isAnagramByLines(){

		List<Line> allLines = new ArrayList<Line>();
		for(Verse v : verses){
			allLines.addAll(v.getLines());
		}
		
		if(allLines.size() <= 1) return false;
		
		Line checker = allLines.remove(0);
		for(Line l : allLines){
			if(!checker.isAnagram(l)){
				return false;
			}
		}
		
		return true;

	}

}
