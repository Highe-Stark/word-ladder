import static org.junit.Assert.*;
import java.util.HashSet;
import org.junit.Test;
import components.WordLadder;

public class WordLadderTest{

	@Test
	public void testFindLadder() {
		HashSet<String> dict = new HashSet<String>();
		dict.add("cat");
		WordLadder wl = new WordLadder("cat", "cat", dict);
		String res = wl.findLadder();
		assertEquals(res, "cat");
	}

	@Test
	public void testFindLadder2() {
		HashSet<String> dict = new HashSet<String>();
		String[] list = {"cat", "dog", "java", "bat", "rat", "bot", "dot", "test", "english"};
		for (String s : list) {
			dict.add(s);
		}
		WordLadder wl = new WordLadder("cat", "dog", dict);
		String res = wl.findLadder();
		assertEquals("cat -> bat -> bot -> dot -> dog", res);
	}
}
