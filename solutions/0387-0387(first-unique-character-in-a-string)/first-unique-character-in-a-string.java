//
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode",
// return 2.
//
//
//
//
// Note: You may assume the string contain only lowercase letters.
//


class Solution {
    /**
     * 直接
     */
    public int firstUniqChar(String s) {
        int i1 = Integer.MAX_VALUE;
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(index[c-'a'] != -1){
                index[c-'a'] = i1;
            }else {
                index[c-'a'] = i;
            }
        }
        int res = i1;
        for(int key: index){
            if(key != -1 && key != i1){
                res = Math.min(res, key);
            }
        }
        return res == i1 ? -1:res;
    }
}
