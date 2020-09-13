// Given a pattern and a string s, find if s follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//
//  
// Example 1:
//
//
// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
//
//
// Example 2:
//
//
// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false
//
//
// Example 3:
//
//
// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false
//
//
// Example 4:
//
//
// Input: pattern = "abba", s = "dog dog dog dog"
// Output: false
//
//
//  
// Constraints:
//
//
// 	1 <= pattern.length <= 300
// 	pattern contains only lower-case English letters.
// 	1 <= s.length <= 3000
// 	s contains only lower-case English letters and spaces ' '.
// 	s does not contain any leading or trailing spaces.
// 	All the words in s are separated by a single space.
//
//


public class Solution {
    public boolean wordPattern(String pattern, String str) {
       char[] charList = pattern.toCharArray();
       String[] strList = str.split(" ");
       if(charList.length != strList.length) return false;
       HashMap<Character, String> map1 = new HashMap<>();
       HashMap<String, Character> map2 = new HashMap<>();
       for(int i = 0; i < charList.length; i++){
           if(map1.containsKey(charList[i])){
               if(!map1.get(charList[i]).equals(strList[i])) return false;
           }else{
               map1.put(charList[i], strList[i]);
           }
           
           if(map2.containsKey(strList[i])){
               if(map2.get(strList[i]) != (charList[i])) return false;
           }else{
               map2.put(strList[i], charList[i]);
           }
       }
       return true;
    }
}
