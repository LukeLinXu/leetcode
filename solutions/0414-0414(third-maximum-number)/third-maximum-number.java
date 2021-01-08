// Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
//
//  
// Example 1:
//
//
// Input: nums = [3,2,1]
// Output: 1
// Explanation: The third maximum is 1.
//
//
// Example 2:
//
//
// Input: nums = [1,2]
// Output: 2
// Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
//
//
// Example 3:
//
//
// Input: nums = [2,2,3,1]
// Output: 1
// Explanation: Note that the third maximum here means the third maximum distinct number.
// Both numbers with value 2 are both considered as second maximum.
//
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 104
// 	231 <= nums[i] <= 231 - 1
//
//
//  
// Follow up: Can you find an O(n) solution?


public class Solution {
//     public int thirdMax(int[] nums) {
//         int length = nums.length;
//         if(length == 0) return 0;
//         int max1 = nums[0];
//         int max2 = nums[0];
//         int max3 = nums[0];
//         boolean b2 = false;
//         boolean b3 = false;
//         for(int i = 0; i < nums.length; i++){
//             int temp = nums[i];

//             if(temp == max1 || (b2 && (temp == max2)) || (b3 && (temp == max3))) continue;
//             if(temp > max1){
//                 if(b2){
//                     max3 = max2;
//                     b3 = true;
//                 }
//                 max2 = max1;
//                 max1 = temp;
//                 b2 = true;
//             }else if(max1 > temp && (!b2 || (temp > max2))){
//                 if(b2){
//                     max3 = max2;
//                     b3 = true;
//                 }else {
//                     b2 = true;
//                 }
//                 max2 = temp;
//             }else if(max2 > temp && ((!b3) || (temp > max3))){
//                 max3 = temp;
//                 b3 = true;
//             }
//             System.out.println(max1+","+max2+","+max3+","+b2+","+b3);

//         }
//         if(!b3) return max1;
//         return max3;
//     }
    
    public int thirdMax(int[] nums) {
        if(nums.length == 1){
	    	 return nums[0];
	     }
	     
	     if(nums.length == 2){
	    	 return nums[0] > nums[1] ? nums[0] : nums[1];
	     }
	     
	     int max1 = Integer.MIN_VALUE;
	     int max2 = Integer.MIN_VALUE;
	     int max3 = Integer.MIN_VALUE;
	     int flag = 0;
	     int count = 0;
	     
	     for(int i =0 ;i < nums.length;i++){
	    	 int tmp  = nums[i];
	    	 if(tmp == max1 || tmp == max2 || tmp == max3){
	    		 if(tmp == Integer.MIN_VALUE){
	    			 flag = 1;
	    		 }
	    		 continue;
	    	 }
	    	 
	    	 if(tmp > max1){
	    		 max3 = max2;
	    		 max2 = max1;
	    		 max1 = tmp;
	    		 count++;
	    	 }else if( tmp > max2){
	    		 max3 = max2;
	    		 max2 = tmp;
	    		 count++;
	    	 }else if(tmp > max3){
	    		 max3 = tmp;
	    		 count++;
	    	 }	 
	     }
	     
	     if(count+flag<3){
	    	 max3 = max1;
	     }
	     
		 return max3;
    }
}
