//
// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//
// The root is the maximum number in the array. 
// The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray divided by the maximum number. 
//
//
//
//
// Construct the maximum tree by the given array and output the root node of this tree.
//
//
// Example 1:
//
// Input: [3,2,1,6,0,5]
// Output: return the tree root node representing the following tree:
//
//       6
//     /   \
//    3     5
//     \    / 
//      2  0   
//        \
//         1
//
//
//
// Note:
//
// The size of the given array will be in the range [1,1000].
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