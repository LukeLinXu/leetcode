//
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
// Note:
//
//
// 	All numbers will be positive integers.
// 	The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
// Input: k = 3, n = 7
// Output: [[1,2,4]]
//
//
// Example 2:
//
//
// Input: k = 3, n = 9
// Output: [[1,2,6], [1,3,5], [2,3,4]]
//
//


public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{9,8,7,6,5,4,3,2,1};
        int length = candidates.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= Math.pow(2, length); i++){
            List<Integer> temp = new ArrayList<>();
            char[] chars = Integer.toBinaryString(i).toCharArray();
            int size = chars.length;
            int count = 0;
            int countk = 0;
            for(int j = 0; j < size; j++){
                if(chars[j] == '1'){
                    countk ++;
                    if(countk > k) break;
                } 
            }
            if(countk != k){
                continue;
            }
            for(int j = length - size; j < length; j++){
                if(chars[size - length + j] == '1'){
                    count += candidates[j];
                    temp.add(candidates[j]);
                    if(count > n) break;
                } 
            }
            if(count == n){
                list.add(temp);
            }
        }
        return list;
    }
}
