// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//  
// Example 1:
//
//
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//
//
// Example 2:
//
//
// Input: height = [4,2,0,3,2,5]
// Output: 9
//
//
//  
// Constraints:
//
//
// 	n == height.length
// 	0 <= n <= 3 * 104
// 	0 <= height[i] <= 105
//
//


public class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int sum = 0;
        int max = 0;
        int maxIndex = 0;
        int tempMax = 0;
        for(int i = 0; i<length; i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
        for(int i = 0; i<maxIndex; i++){
            if(height[i] > tempMax){
                tempMax = height[i];
            }else if(height[i] < tempMax){
                sum += tempMax - height[i];
            }
        }
        tempMax = 0;
        for(int i = length-1; i>maxIndex; i--){
            if(height[i] > tempMax){
                tempMax = height[i];
            }else if(height[i] < tempMax){
                sum += tempMax - height[i];
            }
        }
        return sum;
    }
}
