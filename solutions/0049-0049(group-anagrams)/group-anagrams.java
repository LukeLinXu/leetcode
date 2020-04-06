// Given an array of strings, group anagrams together.
//
// Example:
//
//
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note:
//
//
// 	All inputs will be in lowercase.
// 	The order of your output does not matter.
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
