// Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
//
// For example, given an input list of values [1, 9], when we pick up a number out of it, the chance is that 9 times out of 10 we should pick the number 9 as the answer.
//
// Example 1:
//
//
// Input: 
// ["Solution","pickIndex"]
// [[[1]],[]]
// Output: [null,0]
//
//
//
// Example 2:
//
//
// Input: 
// ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
// [[[1,3]],[],[],[],[],[]]
// Output: [null,0,1,1,1,0]
//
//
// Explanation of Input Syntax:
//
// The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
//
//  
// Constraints:
//
//
// 	1 <= w.length <= 10000
// 	1 <= w[i] <= 10^5
// 	pickIndex will be called at most 10000 times.
//
//


class Solution {
    Random random;
    int[] wSums;
    
    public Solution(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.wSums = w;
    }
     
    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len-1]) + 1;
        int i = Arrays.binarySearch(wSums, idx);
        return i >= 0 ? i : -i-1;
    }
}

/**
 * 垃圾题目，题干太差了，就只是个概率的问题
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
