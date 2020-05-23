// Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 
//
// We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
//
//  
// Example 1:
//
//
//
//
// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
// Output: true
// Explanation: 
// The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
// Other valid sequences are: 
// 0 -> 1 -> 1 -> 0 
// 0 -> 0 -> 0
//
//
// Example 2:
//
//
//
//
// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
// Output: false 
// Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
//
//
// Example 3:
//
//
//
//
// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
// Output: false
// Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
//
//
//  
// Constraints:
//
//
// 	1 <= arr.length <= 5000
// 	0 <= arr[i] <= 9
// 	Each node's value is between [0 - 9].
//
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 直接
     */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    public boolean isValidSequence(TreeNode root, int[] arr, int from) {
        int len = arr.length;
        if(from <= len - 1 && root != null && root.val == arr[from]){
            from++;
            if(from == len && root.left == null && root.right == null){
                return true;
            }else {
                boolean left = isValidSequence(root.left, arr, from);
                if(left){
                    return true;
                }else {
                    return isValidSequence(root.right, arr, from);
                }
            }
        }else {
            return false;
        }
    }
}
