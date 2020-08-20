// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//  
// Example 1:
//
//
// Input: s = "abccccdd"
// Output: 7
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//
// Example 2:
//
//
// Input: s = "a"
// Output: 1
//
//
// Example 3:
//
//
// Input: s = "bb"
// Output: 2
//
//
//  
// Constraints:
//
//
// 	1 <= s.length <= 2000
// 	s consits of lower-case and/or upper-case English letters only.
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
