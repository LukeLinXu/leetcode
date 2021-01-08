// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//  
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//  
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//  
//
// Example:
//
//
// Input: [2,1,5,6,2,3]
// Output: 10
//
//
//  
// Example 1:
//
//
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
//
//
// Example 2:
//
//
// Input: heights = [2,4]
// Output: 4
//
//
//  
// Constraints:
//
//
// 	1 <= heights.length <= 105
// 	0 <= heights[i] <= 104
//
//


public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return 0;
        int max = 0;
        boolean p = false;
        for(int i = 0; i < len ; i++){
            if(i == 0 || heights[i - 1] < heights[i]){
                if(heights[i] == 0) continue;
                int j = i;
                while(j < len && heights[j] >= heights[i]){
                    j++;
                }
                max = Math.max(max, heights[i] * (j - i));
                
            }else if(i != len - 1 && heights[i - 1] >= heights[i] && heights[i + 1] > heights[i]){
                p = true;
                if(heights[i] == 0) continue;
                int j0 = i;
                int j1 = i;
                while(j1 < len && heights[j1] >= heights[i]){
                    j1++;
                }
                while(j0 >= 0 && heights[j0] >= heights[i]){
                    j0--;
                }
                max = Math.max(max, heights[i] * (j1 - j0 - 1));
            }else if(i != 0 && heights[i - 1] > heights[i]){
                p = true;
            }
        }
        if(!p) return max;
        for(int i = len - 1; i >= 0 ; i--){
            if(i == len - 1 || heights[i + 1] < heights[i]){
                if(heights[i] == 0) continue;
                int j = i;
                while(j >= 0 && heights[j] >= heights[i]){
                    j--;
                }
                max = Math.max(max, heights[i] * (i - j));
            }else if(i != 0 && heights[i - 1] > heights[i] && heights[i + 1] >= heights[i]){
                if(heights[i] == 0) continue;
                int j0 = i;
                int j1 = i;
                while(j1 < len && heights[j1] >= heights[i]){
                    j1++;
                }
                while(j0 >= 0 && heights[j0] >= heights[i]){
                    j0--;
                }
                max = Math.max(max, heights[i] * (j1 - j0 - 1));
            }
        }
        return max;
    }
}
