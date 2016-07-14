package cat.test.anagram.beans;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests per al parse del objecte line. Al ser un Parametritzed
 * no es poden mirar tots els mètodes del objecte en una sola classe.
 * @author albicff
 *
 */

@RunWith(Parameterized.class)
public class LineParseContentTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
			{"àèìòù","aeiou"}, 
			{"a-b.c;d?e'f","abcdef"},
			{"yellow mellow","yellowmellow"},
			{"HöLA àDeÜû!","holaadeuu"},
			{"Test tèst+tést+T@sT el test -;.Ara si","testtesttesttsteltestarasi"}
		});
	}
	
    private String input;
    private String expected;

    public LineParseContentTest(String i, String e){
    	input = i;
    	expected = e;
    }

    @Test
	public void setContent(){

    	// creem una line, i parsegem el contingut
		Line l = new Line();
		l.setContent(input);
		
		List<Character> content = l.getContent();
		StringBuilder sb = new StringBuilder();
		for(Character c : content){
			sb.append(c);
		}
		
		// comprovem q sigui l'esperat
		assertEquals(expected,sb.toString());
		

	}

}
