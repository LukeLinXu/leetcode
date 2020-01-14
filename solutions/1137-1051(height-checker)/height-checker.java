// Students are asked to stand in non-decreasing order of heights for an annual photo.
//
// Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
//
//  
// Example 1:
// Input: heights = [1,1,4,2,1,3]
// Output: 3
//
//  
// Constraints:
//
//
// 	1 <= heights.length <= 100
// 	1 <= heights[i] <= 100
//
//


class Solution {
    public int heightChecker(int[] heights) {
        
        //这题太蠢了
        
        
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int result = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != copy[i]){
                result++;
            }
        }
        return result;
    }
}
