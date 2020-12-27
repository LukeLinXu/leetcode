// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//
//
// 	The root is the maximum number in the array.
// 	The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// 	The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//
//
// Construct the maximum tree by the given array and output the root node of this tree.
//
//  
// Example 1:
//
//
// Input: nums = [3,2,1,6,0,5]
// Output: [6,3,5,null,2,0,null,null,1]
//
//
// Example 2:
//
//
// Input: nums = [3,2,1]
// Output: [3,null,2,null,1]
//
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 1000
// 	0 <= nums[i] <= 1000
// 	All integers in nums are unique.
//
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return gotTree(nums, 0, nums.length - 1);
    }

    public TreeNode gotTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int max = nums[start];
        int maxIndex = start;
        for(int i = start; i <= end; i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = gotTree(nums, start, maxIndex - 1);
        treeNode.right = gotTree(nums, maxIndex+1, end);
        return treeNode;
    }
}
