// There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
// You may assume nums1 and nums2 cannot be both empty.
//
// Example 1:
//
//
// nums1 = [1, 3]
// nums2 = [2]
//
// The median is 2.0
//
//
// Example 2:
//
//
// nums1 = [1, 2]
// nums2 = [3, 4]
//
// The median is (2 + 3)/2 = 2.5
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
