// Given a word, you need to judge whether the usage of capitals in it is right or not.
//
// We define the usage of capitals in a word to be right when one of the following cases holds:
//
//
// 	All letters in this word are capitals, like "USA".
// 	All letters in this word are not capitals, like "leetcode".
// 	Only the first letter in this word is capital, like "Google".
//
// Otherwise, we define that this word doesn't use capitals in a right way.
//
//  
//
// Example 1:
//
//
// Input: "USA"
// Output: True
//
//
//  
//
// Example 2:
//
//
// Input: "FlaG"
// Output: False
//
//
//  
//
// Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
//


class Solution {
    /**
     * 直接
     */
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        if (chars.length == 0) return true;
        char aChar = chars[0];
        if(isCap(aChar)){
            if(chars.length >= 2) {
                char bChar = chars[1];
                if(isCap(bChar)){
                    for (int i = 1; i < chars.length; i++){
                        if(isNotCap(chars[i])) return false;
                    }
                    return true;
                }else if(isNotCap(bChar)){
                    for (int i = 1; i < chars.length; i++){
                        if(isCap(chars[i])) return false;
                    }
                    return true;
                }
            }else {
                return true;
            }
        }else if(isNotCap(aChar)){
            for(char c: chars){
                if(isCap(c)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isCap(char c){
        return c >= 'A' && c <= 'Z';
    }

    public boolean isNotCap(char c){
        return c >= 'a' && c <= 'z';
    }
}
