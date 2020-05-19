// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
//
//  
//
// Example 1:
//
//
// Input: s1 = "ab" s2 = "eidbaooo"
// Output: True
// Explanation: s2 contains one permutation of s1 ("ba").
//
//
// Example 2:
//
//
// Input:s1= "ab" s2 = "eidboaoo"
// Output: False
//
//
//  
//
// Note:
//
//
// 	The input strings only contain lower case letters.
// 	The length of both given strings is in range [1, 10,000].
//
//


class Solution {
    /**
     * 直接
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        int[] dict1 = new int[26];
        int[] dict2 = new int[26];
        for(char c: s1.toCharArray()){
            dict1[c-'a']++;
        }
        for(int i = 0; i < len2; i++){
            dict2[s2.charAt(i)-'a']++;
            if(i >= len1) {
                dict2[s2.charAt(i - len1) - 'a']--;
            }
            if(i >= len1 - 1 && checkInclusion(dict1, dict2)){
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion(int[] dict1, int[] dict2) {
        for(int i = 0; i < dict1.length; i++){
            if(dict1[i] != dict2[i]) return false;
        }
        return true;
    }
}
