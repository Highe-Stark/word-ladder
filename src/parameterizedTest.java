import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import components.WordLadder;

@RunWith(value=Parameterized.class)
public class parameterizedTest {

	private String begin;
	private String end;
	private String expected;
	private HashSet<String> dict;

	@Parameters
	public static Collection<String[]> getTestParameters() {
		return Arrays.asList(new String[][] {
			{"dears", "fears", "dears -> fears"},   // begin, end, expected
				{"stone", "money", "stone -> atone -> alone -> clone -> clons -> coons -> conns -> cones -> coney -> money"},
				{"money", "smart", "money -> boney -> bones -> benes -> bends -> beads -> bears -> sears -> scars -> scart -> smart"},
				{"devil", "angel", "devil -> devel -> level -> lever -> leger -> luger -> auger -> anger -> angel"},
				{"atlas", "zebra", "There is no word ladder between atlas and zebra"},
				{"heart", "heart", "heart"},
				{"babes", "child", "babes -> bares -> cares -> carns -> cains -> chins -> chine -> chile -> child"},
				{"mumbo", "ghost", "mumbo -> gumbo -> gombo -> combo -> compo -> comps -> coops -> goops -> glops -> gloss -> glost -> ghost"}
		});
	}

	public parameterizedTest(String beg, String end, String expected) {
		Scanner inFile;
		try {
			inFile = new Scanner(Paths.get("./dictionary.txt"), "UTF-8");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
		while (inFile.hasNext()) {
			this.dict.add(inFile.next());
		}
		this.expected = expected;
		this.begin = beg;
		this.end = end;
	}

	@Test
	public void testLadder() {
		WordLadder wl = new WordLadder(this.begin, this.end, this.dict);
		assertEquals(expected, wl.findLadder());
	}
}
