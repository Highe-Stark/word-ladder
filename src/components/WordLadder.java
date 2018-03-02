package components;

import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * This program defines word ladder class
 * @author Higher Stark
 */

public class WordLadder
{
	private String begin;
	private String end;
	private HashSet<String> dict;

	public WordLadder (String beg, String end, HashSet<String> dict) throws RuntimeException
	{
		if (beg == null || end == null || dict == null) throw new NullPointerException("null is not accepted");
		this.begin = beg;
		this.end = end;
		this.dict = dict;
	}

	public String findLadder()
	{
		String notFound = "No word ladder found from " + begin + " to " + end + ".";
		if (begin.length() != end.length()) return notFound; 
		// stk for a stack of words
		Stack<String> stk = new Stack<String>();
		stk.push(begin);
		// ladderTree contains a queue of stack representing ladder
		LinkedList<Stack<String>> ladderTree = new LinkedList<Stack<String>>();
		ladderTree.add(stk);
		// visited contains words in the stacks
		HashSet<String> visited = new HashSet<String>();
		visited.add(begin);
		while (!ladderTree.isEmpty())
		{
			stk = ladderTree.poll();
			String last = stk.peek();
			int len = last.length();
			for ( int i = 0; i < len; i++)
			{
				StringBuilder now = new StringBuilder();
				now.append(last);
				for (char rp = 'a'; rp <= 'z'; rp++)
				{
					now.setCharAt(i, rp);
					if (visited.contains(now)) continue;
					if (now.equals(end)) {
						String res;
						Stack<String> tmp = new Stack<String>();
						while (!stk.empty()) {
							tmp.push(stk.pop());
						}
						res = "";
						while (!tmp.empty()) {
							res += tmp.pop() + " -> ";
						}
						res += end;
						return res;
					}
						Stack<String> stkcpy = new Stack<String>();
					       stkcpy	= (Stack<String>) stk.clone();
						stkcpy.push(now.toString());
						ladderTree.add(stkcpy);
				}
			}
		}
		return notFound;
	}
}
