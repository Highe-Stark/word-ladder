import java.util.*;
import java.nio.file.Paths;
import java.io.*;
import components.*;
/**
 * This file implements entry to build word ladder
 * @author Higher Stark
 */

public class Entry
{
	public static void main(String[] args)
	{
		String beg;		// the word to begin in the word ladder
		String end;		// the destination word of the ladder
		HashSet<String> dict = new HashSet<String>();	//the dictionary
		Scanner in  = new Scanner(System.in);
		System.out.print("Dictionary file path: ");
		String dictPath = in.nextLine();
		Scanner dictFile;
		try {
		dictFile = new Scanner(Paths.get(dictPath), "UTF-8");
		}
		catch (IOException e) {
			System.out.println("Error: " + dictPath + " not found!");
			System.out.println("Program Abort");
			return;
		}
		while (dictFile.hasNext()) {
			dict.add(dictFile.next());
		}
		System.out.print("The Word to begin: ");
		beg = in.next();
		if (beg == null || ! dict.contains(beg)) {
			System.out.println(beg + " doesn't exist in the dictionary!");
			System.out.println("Program Abort.");
			return;
		}
		System.out.print("The Destination: ");
		end = in.next();
		if (end == null || !dict.contains(end)) {
			System.out.println(end + " doesn't exist in the dictionary!");
			System.out.println("Program Abort.");
		}
		WordLadder wl = new WordLadder(beg, end, dict);
		System.out.println(wl.findLadder());
	}
}
