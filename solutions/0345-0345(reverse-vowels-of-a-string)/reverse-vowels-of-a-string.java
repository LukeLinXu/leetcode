// Write a function that takes a string as input and reverse only the vowels of a string.
//
// Example 1:
//
//
// Input: "hello"
// Output: "holle"
//
//
//
// Example 2:
//
//
// Input: "leetcode"
// Output: "leotcede"
//
//
// Note:
// The vowels does not include the letter "y".
//
//  
//


public class Solution {
    public String reverseVowels(String s) {
        if(s == null) return null;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<Character>(10);
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int x = -1;
        int y = chars.length;
        while(true){
            for(int i = x+1; i <= chars.length - 1; i++){
                if(set.contains(chars[i])){
                    x = i;
                    break;
                }
            }
            if(x == -1) return s;
            for(int i = y-1; i >= 0; i--){
                if(set.contains(chars[i])){
                    y = i;
                    break;
                }
            }
            if(y <= x) break;
            char c = chars[x];
            chars[x] = chars[y];
            chars[y] = c;
        }
        return String.valueOf(chars);
    }
}
