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
			String help = "Usage:\n  -d <path> \n\tPath of the dictionary file.\n  -b <word> \n\tthe word where the ladder starts.\n  -e <word> \n\tthe destination word.\n";
			if (args.length != 6) {
				System.out.println("Invalid paramaters\n");
				System.out.println(help);
				return;
			}
			if (!(args[0].equals("-d") && args[2].equals("-b") && args[4].equals("-e"))) {
				System.out.println("Invalid paramaters\n" + help);
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
		try {
			WordLadder wl = new WordLadder(beg, end, dict);
			System.out.println(wl.findLadder());
		}
		catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	// private static String[] parseArgs(String[] a
}
