// We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
//
// A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
// Return a list of all uncommon words. 
//
// You may return the list in any order.
//
//  
//
//
//
//
//
// Example 1:
//
//
// Input: A = "this apple is sweet", B = "this apple is sour"
// Output: ["sweet","sour"]
//
//
//
// Example 2:
//
//
// Input: A = "apple apple", B = "banana"
// Output: ["banana"]
//
//
//  
//
// Note:
//
//
// 	0 <= A.length <= 200
// 	0 <= B.length <= 200
// 	A and B both contain only spaces and lowercase letters.
//
//
//
//


class Solution {
    /**
     * 直接
     */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s: A.split(" ")){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String s: B.split(" ")){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int count = 0;
        for(int i: map.values()){
            if(i == 1) count++;
        }
        String[] res = new String[count];
        int index = 0;
        for (String s: map.keySet()){
            if(map.get(s) == 1){
                res[index] = s;
                index++;
            }
        }
        return res;
    }
}
