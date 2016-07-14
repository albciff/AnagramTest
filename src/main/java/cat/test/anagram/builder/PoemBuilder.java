package cat.test.anagram.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cat.test.anagram.beans.Line;
import cat.test.anagram.beans.Poem;
import cat.test.anagram.beans.Verse;

/**
 * Builder per a generar Poem's a partir del contingut del fitxer o
 * d'un string
 * 
 * @author albciff
 *
 */
public class PoemBuilder {

	/**
	 * Metode per a parsejar el poem a partir del contingut d'un fitxer
	 * @param f
	 * @return
	 */
	public Poem parse(File f){
		try {
			return this.parse(new FileReader(f));
		} catch (FileNotFoundException e) {
			// en cas de problemes tornem un objecte
			// q en cas de preguntar per l'anagrama retornarà false
			// pero evitarem NPE
			return new Poem();
		}
	}

	/**
	 * Metode per a parsejar el Poem a partir d'un string
	 * @param s
	 * @return
	 */
	public Poem parse(String s){
		return this.parse(new StringReader(s));
	}

	private Poem parse(Reader r){

		BufferedReader reader = null;

		try{
			reader = new BufferedReader(r);

			Poem poem = new Poem();
			Verse verse = new Verse();
			Line line = new Line();

			// llegim el contingut linea a linea
			String lineContent = reader.readLine();	
			while (lineContent != null) {
				// linea blanc... nou vers
				if("".equals(lineContent.trim())){
					poem.addVerse(verse);
					verse = new Verse();
				}else{
					// linea amb contingut, seguim omplint el vers
					line = new Line();
					line.setContent(lineContent);
					verse.addLine(line);
				}
				lineContent = reader.readLine();
			}
			
			// afegeix sempre l'ultim vers generat...
			// en cas q no tingui contingut no afectara tampoc
			poem.addVerse(verse);

			return poem;
		}catch(Exception e){
			// en cas de problemes tornem un objecte
			// q en cas de preguntar per l'anagrama retornarà false
			// pero evitarem NPE
			return new Poem();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {}
			}
		}
	}


}
