package com.abhishek.dojo.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*

You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


 */
public class ReorderDataInLogFiles {
	public static void main(String[] args) {
		ReorderDataInLogFiles r = new ReorderDataInLogFiles();
		r.reorderLogFiles(new String[] {"6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"});
	}

	public String[] reorderLogFiles(String[] logs) {
		String[] result = new String[logs.length]; List<String> diglogs = new ArrayList<>(), letterLogs = new ArrayList<>();
		for (String log : logs) {
			if (Character.isDigit(log.charAt(log.indexOf(" ") + 1))) 
				diglogs.add(log);
			else 
				letterLogs.add(log);
		}
		Collections.sort(letterLogs, (o1, o2) -> {
			String item1 = o1.substring(o1.indexOf(" ") + 1);
			String item2 = o2.substring(o2.indexOf(" ") + 1);
			return o1.substring(o1.indexOf(" ") + 1).equals(item2) ? o1.compareTo(o2) : item1.compareTo(item2);
		});
		int i = 0;
		for (; i < letterLogs.size(); i++) 
			result[i] = letterLogs.get(i);
		
		for (String log : diglogs) {
			result[i] = log;
			i++;
		}
		return result;
	}

}
