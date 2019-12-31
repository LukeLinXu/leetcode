// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
//
// Example 1:
//
// Input: [1, 2, 2, 3, 1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
//
//
//
//
// Example 2:
//
// Input: [1,2,2,3,1,4,2]
// Output: 6
//
//
//
// Note:
// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.
//


class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(left.get(nums[i]) == null){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) +1);
        }
        Integer min = Collections.max(count.values());
        int minCount = nums.length;
        for(int num: count.keySet()){
            if(count.get(num) == min){
                minCount = Math.min(minCount, right.get(num) - left.get(num)+1);
            }
        }
        return minCount;
    }
}
