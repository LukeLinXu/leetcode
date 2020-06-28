// Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
//
//  
//
// Example 1:
//
//
//
// Input: A = "ab", B = "ba"
// Output: true
//
//
//
// Example 2:
//
//
// Input: A = "ab", B = "ab"
// Output: false
//
//
//
// Example 3:
//
//
// Input: A = "aa", B = "aa"
// Output: true
//
//
//
// Example 4:
//
//
// Input: A = "aaaaaaabc", B = "aaaaaaacb"
// Output: true
//
//
//
// Example 5:
//
//
// Input: A = "", B = "aa"
// Output: false
//
//
//
//
//
//
//
//  
// Constraints:
//
//
// 	0 <= A.length <= 20000
// 	0 <= B.length <= 20000
// 	A and B consist only of lowercase letters.
//
//


class Solution {
    /**
     * 直接
     */
    public boolean buddyStrings(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if(lenA != lenB) return false;
        List<Pair> list = new ArrayList<>();
        boolean hasDuplicate = false;
        int[] size = new int[26];
        for(int i = 0; i < lenA; i++){
            size[A.charAt(i) - 'a']++;
            if(size[A.charAt(i) - 'a'] >= 2){
                hasDuplicate = true;
            }
            
            if(A.charAt(i) != B.charAt(i)){
                list.add(new Pair(A.charAt(i), B.charAt(i)));
            }
        }
        if(list.size() == 0 && hasDuplicate) return true;
        if(list.size() != 2) return false;
        return list.get(0).x == list.get(1).y && list.get(1).x == list.get(0).y;
    }
    
    public static class Pair{
        private final int x;
        private final int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
