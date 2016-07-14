package cat.test.anagram.beans;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cat.test.anagram.builder.PoemBuilder;

/**
 * Tests per al parse del objecte line. Al ser un Parametritzed
 * no es poden mirar tots els mètodes del objecte en una sola classe.
 * @author albicff
 *
 */

@RunWith(Parameterized.class)
public class PoemIsAnagramTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
			{"/anagramPoems/correct/Poem1.txt",true},
			{"/anagramPoems/correct/Poem2.txt",true},
			{"/anagramPoems/correct/Poem3.txt",true},
			{"/anagramPoems/correct/Poem4.txt",true},
			{"/anagramPoems/correct/Poem5.txt",true},
			{"/anagramPoems/correct/Poem6.txt",true},
			{"/anagramPoems/incorrect/Poem1.txt",false},
			{"/anagramPoems/incorrect/Poem2.txt",false},
			{"/anagramPoems/incorrect/Poem3.txt",false},
			{"/anagramPoems/incorrect/Poem4.txt",false},
			{"/anagramPoems/incorrect/Poem5.txt",false},
			{"/anagramPoems/incorrect/Poem6.txt",false},
			{"/anagramPoems/incorrect/Poem7.txt",false},
			{"/anagramPoems/incorrect/Poem8.txt",false}
		});
	}

    private String poemPath;
    private boolean expected;

    public PoemIsAnagramTest(String p, boolean e){
    	poemPath = p;
    	expected = e;
    }
	
	@Test
	public void isAnagram(){
		PoemBuilder poemBuilder = new PoemBuilder();
		Poem poem = poemBuilder.parse(new File(PoemIsAnagramTest.class.getResource(poemPath).getFile()));
		assertEquals(expected, poem.isAnagram());
	}
}
