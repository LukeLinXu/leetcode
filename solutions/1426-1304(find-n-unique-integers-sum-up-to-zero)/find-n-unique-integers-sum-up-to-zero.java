// Given an integer n, return any array containing n unique integers such that they add up to 0.
//
//  
// Example 1:
//
//
// Input: n = 5
// Output: [-7,-1,1,3,4]
// Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
//
//
// Example 2:
//
//
// Input: n = 3
// Output: [-1,0,1]
//
//
// Example 3:
//
//
// Input: n = 1
// Output: [0]
//
//
//  
// Constraints:
//
//
// 	1 <= n <= 1000
//


class Solution {
    /**
     * 直接
     * @param n
     * @return
     */
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        for(int i = 0; i < n/2; i++){
            res[i] = -(i+1);
            res[n-1-i] = (i+1);
        }
        if(n%2 != 0){
            res[n/2] = 0;
        }
        return res;
    }
}
