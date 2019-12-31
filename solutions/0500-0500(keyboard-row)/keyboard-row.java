// Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
//
//  
//
//
//  
//
// Example:
//
//
// Input: ["Hello", "Alaska", "Dad", "Peace"]
// Output: ["Alaska", "Dad"]
//
//
//  
//
// Note:
//
//
// 	You may use one character in the keyboard more than once.
// 	You may assume the input string will only contain letters of alphabet.
//
//


public class Solution {
    public String[] findWords(String[] words) {
        String[] s = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashSet<Character>[] sets = new HashSet[]{new HashSet(s[0].length()*2), new HashSet(s[1].length()*2), new HashSet(s[2].length()*2)};
        for(int i = 0; i < 3; i++){
            for(char c : s[i].toCharArray()){
                sets[i].add(c);
                sets[i].add(Character.toUpperCase(c));
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String word : words){
            int pos = -1;
            boolean p = true;
            for(char c : word.toCharArray()){
                if(pos == -1){
                    if(sets[0].contains(c)) pos = 0;
                    if(sets[1].contains(c)) pos = 1;
                    if(sets[2].contains(c)) pos = 2;
                }else {
                    if(!sets[pos].contains(c)){
                        p = false;
                        break;  
                    } 
                }
            }
            if(!p) continue;
            list.add(word);
        }
        String[] result = new String[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
