// You are given an array of strings words and a string chars.
//
// A string is good if it can be formed by characters from chars (each character can only be used once).
//
// Return the sum of lengths of all good strings in words.
//
//  
//
// Example 1:
//
//
// Input: words = ["cat","bt","hat","tree"], chars = "atach"
// Output: 6
// Explanation: 
// The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//
//
// Example 2:
//
//
// Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
// Output: 10
// Explanation: 
// The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
//
//
//  
//
// Note:
//
//
// 	1 <= words.length <= 1000
// 	1 <= words[i].length, chars.length <= 100
// 	All strings contain lowercase English letters only.
//


class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : chars.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for(String word : words){
            HashMap<Character, Integer> temp = (HashMap<Character, Integer>) map.clone();
            boolean isValid = true;
            for(char c : word.toCharArray()){
                if(temp.containsKey(c) && temp.get(c) > 0){
                    temp.put(c, temp.get(c) - 1);
                }else {
                    isValid = false;
                    break;
                }
            }
            if(isValid) result += word.length();
        }
        return result;
    }
}
