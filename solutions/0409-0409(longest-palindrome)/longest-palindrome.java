// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
// This is case sensitive, for example "Aa" is not considered a palindrome here.
//
// Note:
// Assume the length of given string will not exceed 1,010.
//
//
// Example: 
//
// Input:
// "abccccdd"
//
// Output:
// 7
//
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//


public class Solution {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean hasSingle = false;
        int count = 0;
        char current = 0;

        for(int i = 0; i < chars.length; i++){
            if(i == chars.length - 1){
                hasSingle = true;
                break;
            }
            
            if(chars[i] == chars[i+1]){
                count += 2;
                i++;
            }else{
                hasSingle = true;
            }
        }

        if(hasSingle) count++;
        return count;
    }
}
