// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
// Return true if and only if the nodes corresponding to the values x and y are cousins.
//
//  
//
// Example 1:
//
//
//
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false
//
//
//
// Example 2:
//
//
//
// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true
//
//
//
// Example 3:
//
//
//
//
// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
//
//
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the tree will be between 2 and 100.
// 	Each node has a unique integer value from 1 to 100.
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
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;
        int cousinsHelper = isCousinsHelper(root, x, 0, y, null);
        if(cousinsHelper == -1) return false;
        return cousinsHelper == isCousinsHelper(root, y, 0, x, null);
    }

    public static int isCousinsHelper(TreeNode temp, int target, int count, int nonTarget, TreeNode parent) {
        if(temp == null) return -1;
        if(temp.val == target){
            if(parent.left != null && parent.right != null && parent.left.val+parent.right.val == target+ nonTarget) return -1;
            return count;
        }
        int left = isCousinsHelper(temp.left, target, count+1, nonTarget, temp);
        if(left != -1) return left;
        return isCousinsHelper(temp.right, target, count+1, nonTarget, temp);
    }
}
