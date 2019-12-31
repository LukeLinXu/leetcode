// Given a sorted integer array without duplicates, return the summary of its ranges.
//
// Example 1:
//
//
// Input:  [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
//
//
// Example 2:
//
//
// Input:  [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
//
//


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        ArrayList<String> list = new ArrayList<String>();
        if(len == 0) return list;
        if(len == 1){
            list.add(Integer.toString(nums[0]));
            return list;
        }
        boolean linked = false;
        int start = nums[0];
        int end = nums[0];
        for(int i = 0; i < len; i++){
            boolean p = false;
            if(i != len -1){
                p = (nums[i+1] - nums[i]) == 1;
            }
            if(linked){
                end = nums[i];
                if(!p){
                    list.add(start+"->"+end);
                }
            }else{
                start = nums[i];
                end = nums[i];
                if(!p){
                    list.add(Integer.toString(start));
                }
            }
            linked = p;
        }
        return list;
    }
}
