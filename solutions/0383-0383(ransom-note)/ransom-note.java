// Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
// Each letter in the magazine string can only be used once in your ransom note.
//
//  
// Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:
// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:
// Input: ransomNote = "aa", magazine = "aab"
// Output: true
//
//  
// Constraints:
//
//
// 	You may assume that both strings contain only lowercase letters.
//
//


class Solution {
    /**
     * 直接
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: ransomNote.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
