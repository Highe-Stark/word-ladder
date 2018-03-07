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
}
