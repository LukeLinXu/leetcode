// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//
// You can use each character in text at most once. Return the maximum number of instances that can be formed.
//
//  
// Example 1:
//
//
//
//
// Input: text = "nlaebolko"
// Output: 1
//
//
// Example 2:
//
//
//
//
// Input: text = "loonbalxballpoon"
// Output: 2
//
//
// Example 3:
//
//
// Input: text = "leetcode"
// Output: 0
//
//
//  
// Constraints:
//
//
// 	1 <= text.length <= 10^4
// 	text consists of lower case English letters only.
//


class Solution {
    /**
     * 直接
     */
    public int maxNumberOfBalloons(String text) {
        int[] charMap = new int[26];
        for(char c: text.toCharArray()){
            charMap[c-'a']++;
        }
        int count = 0;
        while (charMap['b'-'a'] >=1 && charMap['a'-'a'] >=1 && charMap['l'-'a'] >=2 && charMap['o'-'a'] >=2 && charMap['n'-'a'] >=1){
            count++;
            charMap['b'-'a']--;
            charMap['a'-'a']--;
            charMap['l'-'a']-=2;
            charMap['o'-'a']-=2;
            charMap['n'-'a']--;
        }
        return count;
    }
}
