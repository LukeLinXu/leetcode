// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
// Note: The algorithm should run in linear time and in O(1) space.
//
// Example 1:
//
//
// Input: [3,2,3]
// Output: [3]
//
// Example 2:
//
//
// Input: [1,1,1,3,3,2,2,2]
// Output: [1,2]
//


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int k = 3;
        int len = nums.length;
        if(len == 0){
            return new ArrayList<>();
        }
        int[] count = new int[k - 1];
        int[] candi = new int[k - 1];

        for(int i = 0; i < len; i++){
            boolean settled = false;
            for(int j = 0; j < k - 1; j++){
                if(candi[j] == nums[i]){
                    count[j]++;
                    settled = true;
                    break;
                }
            }
            if(settled) continue;
            for(int j = 0; j < k - 1; j++){
                if(count[j] == 0){
                    candi[j] = nums[i];
                    count[j] = 1;
                    settled = true;
                    break;
                }
            }
            if(settled) continue;
            for(int j = 0; j < k - 1; j++){
                if(count[j] > 0){
                    count[j] --;
                }
            }
        }
        
        Arrays.fill(count, 0);
        for(int i = 0; i < len; i++){
            for(int j = 0; j < k - 1; j++){
                if(candi[j] == nums[i]){
                    count[j]++;
                    break;
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < k - 1; i++){
            if(count[i] > len/k){
                list.add(candi[i]);       
            }
        }
        return list;
    }
}
