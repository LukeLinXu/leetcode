// Given two strings s and t , write a function to determine if t is an anagram of s.
//
// Example 1:
//
//
// Input: s = "anagram", t = "nagaram"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "rat", t = "car"
// Output: false
//
//
// Note:
// You may assume the string contains only lowercase alphabets.
//
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?
//


public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[256];
        if(s.length() == t.length()){
            for(char c : s.toCharArray()){
                count[c] ++;
            }
            for(char c : t.toCharArray()){
                count[c] --;
                if(count[c] < 0) return false;
            }
            return true;
        }else {
            return false;
        }
    }
}
