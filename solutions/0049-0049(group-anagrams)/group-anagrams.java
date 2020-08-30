// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//  
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]
//
//  
// Constraints:
//
//
// 	1 <= strs.length <= 104
// 	0 <= strs[i].length <= 100
// 	strs[i] consists of lower-case English letters.
//
//


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String v = String.valueOf(chars);
            if(map.containsKey(v)){
                map.get(v).add(s);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(v, list);
            }
        }
        ArrayList<List<String>> list2 = new ArrayList<>();
        list2.addAll(map.values());
        return list2;
    }
}
