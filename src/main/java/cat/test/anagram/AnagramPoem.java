package cat.test.anagram;

import java.io.File;

import cat.test.anagram.beans.Poem;
import cat.test.anagram.builder.PoemBuilder;

/**
 * Main per a provar
 * @author albciff
 *
 */
public class AnagramPoem {

	public static void main(String[] args) {
		if(args == null || args.length < 2){
			logErrorArgs();
			return;
		}
		
		PoemBuilder pbuilder = new PoemBuilder();
		Poem poem = null;
		
//		if("-s".equals(args[0].toLowerCase())){
//			poem = pbuilder.parse(args[1]);
//		}else
		if("-f".equals(args[0].toLowerCase())){
			poem = pbuilder.parse(new File(args[1]));
		}else{
			logErrorArgs();	
		}
		
		System.out.println("El Poema proporciona és anagramic? : " + poem.isAnagram());
		
	}
	
	public static void logErrorArgs(){
		System.out.println("Crida incorrecte.");
		System.out.println("Els paràmetres han de ser:"); 
		System.out.println("-f path/to/poem");
//		System.out.println("----------- o -------------- ");
//		System.out.println("-s poemAsString");
	}
}
