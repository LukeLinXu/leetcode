// Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
//
// In the American keyboard:
//
//
// 	the first row consists of the characters "qwertyuiop",
// 	the second row consists of the characters "asdfghjkl", and
// 	the third row consists of the characters "zxcvbnm".
//
//
//  
// Example 1:
//
//
// Input: words = ["Hello","Alaska","Dad","Peace"]
// Output: ["Alaska","Dad"]
//
//
// Example 2:
//
//
// Input: words = ["omk"]
// Output: []
//
//
// Example 3:
//
//
// Input: words = ["adsdf","sfd"]
// Output: ["adsdf","sfd"]
//
//
//  
// Constraints:
//
//
// 	1 <= words.length <= 20
// 	1 <= words[i].length <= 100
// 	words[i] consists of English letters (both lowercase and uppercase). 
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
