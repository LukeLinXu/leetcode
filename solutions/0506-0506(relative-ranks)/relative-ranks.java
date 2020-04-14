//
// Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
//
// Example 1:
//
// Input: [5, 4, 3, 2, 1]
// Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
// Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two athletes, you just need to output their relative ranks according to their scores.
//
//
//
// Note:
//
// N is a positive integer and won't exceed 10,000.
// All the scores of athletes are guaranteed to be unique.
//
//
//


class Solution {
    /**
     * 直接
     */
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] res = nums.clone();
        String[] resString = new String[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            map.put(nums[i], len - i);
        }
        for(int i = 0; i < len; i++){
            int position = map.get(res[i]);
            String temp = String.valueOf(position);
            if(position == 1){
                temp = "Gold Medal";
            }else if(position == 2){
                temp = "Silver Medal";
            }else if(position == 3){
                temp = "Bronze Medal";
            }
            resString[i] = temp;
        }
        return resString;
    }
}
