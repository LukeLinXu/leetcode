// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
// Example 1:
//
//
// Input: pattern = "abba", str = "dog cat cat dog"
// Output: true
//
// Example 2:
//
//
// Input:pattern = "abba", str = "dog cat cat fish"
// Output: false
//
// Example 3:
//
//
// Input: pattern = "aaaa", str = "dog cat cat dog"
// Output: false
//
// Example 4:
//
//
// Input: pattern = "abba", str = "dog dog dog dog"
// Output: false
//
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
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
