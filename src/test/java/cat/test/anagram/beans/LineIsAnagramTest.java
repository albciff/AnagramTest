package cat.test.anagram.beans;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests per a comprovar el isAnagram del objecte line. Al ser un Parametritzed
 * no es poden mirar tots els mètodes del objecte en una sola classe.
 * @author albicff
 *
 */

@RunWith(Parameterized.class)
public class LineIsAnagramTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
			{"aran","nara",true}, 
			{"hola com estas","hola com estas",false},
			{"anagrama","amagaran",true}, 
			{"à.a.b","baa",true},
			{"elefant","girafa",false},
			{"això és una altre prova!","prova això una altre és...",true},
			{"Pop sis","SIS POP",true},
			{"Adeu aloh hola","Hola aloh ueda",true},
			{"Adeu adeu","ueda",false}
		});
	}
	
    private String original;
    private String candidate;
    private boolean expected;

    public LineIsAnagramTest(String o, String c, boolean e){
    	original = o;
    	candidate = c;
    	expected = e;
    }

    @Test
	public void isAnagram(){

    	// creem una line, i parsegem el contingut
		Line lineOriginal = new Line();
		lineOriginal.setContent(original);
		
		// instanciem l'anagrama
		Line lineAnagrama = new Line();
		lineAnagrama.setContent(candidate);
		
		// comprovem q sigui l'esperat
		assertEquals(expected,lineOriginal.isAnagram(lineAnagrama));
		
	}

}
