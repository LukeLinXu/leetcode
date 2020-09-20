// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//
// 	Only numbers 1 through 9 are used.
// 	Each number is used at most once.
//
//
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
//  
// Example 1:
//
//
// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
//
// Example 2:
//
//
// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
//
//
// Example 3:
//
//
// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
//
//
// Example 4:
//
//
// Input: k = 3, n = 2
// Output: []
// Explanation: There are no valid combinations.
//
//
// Example 5:
//
//
// Input: k = 9, n = 45
// Output: [[1,2,3,4,5,6,7,8,9]]
// Explanation:
// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
// ​​​​​​​There are no other valid combinations.
//
//
//  
// Constraints:
//
//
// 	2 <= k <= 9
// 	1 <= n <= 60
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
