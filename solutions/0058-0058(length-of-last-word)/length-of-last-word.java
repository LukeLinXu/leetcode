// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a maximal substring consisting of non-space characters only.
//
// Example:
//
//
// Input: "Hello World"
// Output: 5
//
//
//  
//


class Solution {
    /**
     * 直接
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        if(s1.length != 0){
            return s1[s1.length - 1].length();
        }else {
            return 0;
        }
    }
}
