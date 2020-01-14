// Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
//
// Example 1:
//
//
// Input: S = "loveleetcode", C = 'e'
// Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
//  
//
// Note:
//
//
// 	S string length is in [1, 10000].
// 	C is a single character, and guaranteed to be in string S.
// 	All letters in S and C are lowercase.
//
//


class Solution {
    
    /**
     * 正向反向各刷一次即可
     */
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
    /**
     * 前后增加假的index, 用来计算差值
     */
    // public int[] shortestToChar(String S, char C) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     list.add(-S.length());
    //     for(int i = 0; i < S.length(); i++){
    //         if(S.charAt(i) == C){
    //             list.add(i);
    //         }
    //     }
    //     list.add(2*S.length());
    //     int[] res = new int[S.length()];
    //     int index = 0;
    //     for(int i = 0; i < S.length() && index < list.size(); i++){
    //         int left = list.get(index);
    //         int right = list.get(index+1);
    //         if(i > left && i < right){
    //             res[i] = Math.min(i - left, right - i);
    //         }else if(i == right){
    //             index++;
    //         }
    //     }
    //     return res;
    // }
}
