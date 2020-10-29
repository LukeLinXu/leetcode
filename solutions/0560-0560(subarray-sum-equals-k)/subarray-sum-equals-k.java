// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
//
//  
// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 2 * 104
// 	-1000 <= nums[i] <= 1000
// 	-107 <= k <= 107
//
//


class Solution {
    /**
     * 更优秀的办法，在于我想的是先确定start,再找end,这个方法先找end,再找start，更快
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    /**
     * 直接
     */
    public static int subarraySumMy(int[] nums, int k) {
        long[] sums = new long[nums.length];
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                sums[i] = nums[i];
            }else {
                sums[i] = sums[i-1] + nums[i];
            }
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        int count = map.getOrDefault((long)k, 0);
        for (long v1 : sums) {
            if (map.getOrDefault(v1, 0) == 0) {
                map.remove(v1);
            } else {
                map.put(v1, map.get(v1) - 1);
            }
            long v2 = v1 + k;
            count += map.getOrDefault(v2, 0);
        }
        return count;
    }
}
