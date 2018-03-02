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
		String beg = "";		// the word to begin in the word ladder
		String end = "";		// the destination word of the ladder
		HashSet<String> dict = new HashSet<String>();	//the dictionary
		String dictPath = "";
		boolean hasArgs = false;  // no arguments in args

		if (args.length != 0) {
			if (args.length != 6) {
				System.out.println("Invalid paramaters");
				System.out.println("System Abort");
				return;
			}
			if (!(args[0].equals("-d") && args[2].equals("-b") && args[4].equals("-e"))) {
				System.out.println("Invalid paramaters\nSystem Abort");
				return;
			}
			dictPath = args[1];
			beg = args[3];
			end = args[5];
			hasArgs = true;
		}

		Scanner in  = new Scanner(System.in);
		if (!hasArgs) {
			System.out.print("Dictionary file path: ");
			dictPath = in.nextLine();
		}
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
		if (!hasArgs) {
			System.out.print("The Word to begin: ");
			beg = in.next();
		}
		if (beg == null || ! dict.contains(beg)) {
			System.out.println(beg + " doesn't exist in the dictionary!");
			System.out.println("Program Abort.");
			return;
		}
		if (!hasArgs) {
			System.out.print("The Destination: ");
			end = in.next();
		}
		if (end == null || !dict.contains(end)) {
			System.out.println(end + " doesn't exist in the dictionary!");
			System.out.println("Program Abort.");
		}
		WordLadder wl = new WordLadder(beg, end, dict);
		System.out.println(wl.findLadder());
	}

	// private static String[] parseArgs(String[] a
}
