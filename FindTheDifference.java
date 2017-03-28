/*
389. Find the Difference
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
*/
public class Solution {
	
		/**
		  我的中规中矩解法
		**/
    public char findTheDifference(String s, String t) {
        if (s.equals("")) {
            return t.charAt(0);
        }
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];

        for (int i = 0; i < s.toCharArray().length; i++) {
            sCharCount[s.charAt(i) - 'a']++;
            tCharCount[t.charAt(i) - 'a']++;
        }
        tCharCount[t.charAt(t.length() - 1) - 'a']++;
        for (int i = 0; i < sCharCount.length; i++) {
            if (sCharCount[i] != tCharCount[i]) {
                return (char) (i + 'a');
            }
        }

        return ' ';
    }
    
    /**
       文艺青年的异或解法(两个相同的数异或得0，0异或上一个其他等于其他)
    **/
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	ans ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
        	ans ^= t.charAt(i);
        }
        return ans;
    }

}