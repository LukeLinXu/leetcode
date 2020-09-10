// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
// Follow up: The overall run time complexity should be O(log (m+n)).
//
//  
// Example 1:
//
//
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
//
//
// Example 2:
//
//
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
// Example 3:
//
//
// Input: nums1 = [0,0], nums2 = [0,0]
// Output: 0.00000
//
//
// Example 4:
//
//
// Input: nums1 = [], nums2 = [1]
// Output: 1.00000
//
//
// Example 5:
//
//
// Input: nums1 = [2], nums2 = []
// Output: 2.00000
//
//
//  
// Constraints:
//
//
// 	nums1.length == m
// 	nums2.length == n
// 	0 <= m <= 1000
// 	0 <= n <= 1000
// 	1 <= m + n <= 2000
// 	-106 <= nums1[i], nums2[i] <= 106
//
//


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         
         int len1 = nums1.length;
         int len2 = nums2.length;
         int target = (len1 + len2)/2;
         boolean p = (len1+len2)%2 == 1;
         int i1 = 0;
         int i2 = 0;
         int currentPos = 0;
         int current = 0;
         int currentSlow = 0;
         while(currentPos <= target){
             
             if(i1 < len1 && i2 < len2){
                 if(nums1[i1]<=nums2[i2]){
                     
                     currentSlow = current;
                     current = nums1[i1];
                     i1 ++;
                 }else{
                     
                     currentSlow = current;
                     current = nums2[i2];
                     i2 ++;
                 }
             }else if(i1 < len1){
                 
                 currentSlow = current;
                 current = nums1[i1];
                 i1 ++;
             }else if(i2 < len2){
                 
                 currentSlow = current;
                 current = nums2[i2];
                 i2 ++;
             }
             currentPos ++;
         }
         
         return p?current:(current+currentSlow)/2d;
    }
}
