/*
344. Reverse String
Write a function that takes a string as input and returns the string reversed.
Example:
Given s = "hello", return "olleh
*/

public class Solution {
    public String reverseString(String s) {
        if (s == null || s.equals("")) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return new String(chars);
    }
    
    /*
     发现这样似乎更方便一点。。。
    */
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}