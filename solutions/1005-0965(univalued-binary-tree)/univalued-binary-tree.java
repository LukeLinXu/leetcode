// A binary tree is univalued if every node in the tree has the same value.
//
// Return true if and only if the given tree is univalued.
//
//  
//
// Example 1:
//
//
// Input: [1,1,1,1,1,null,1]
// Output: true
//
//
//
// Example 2:
//
//
// Input: [2,2,2,5,2]
// Output: false
//
//
//
//  
//
// Note:
//
//
// 	The number of nodes in the given tree will be in the range [1, 100].
// 	Each node's value will be an integer in the range [0, 99].
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
    /**
     * 直接
     */
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root == null ? -1 : root.val);
    }

    public boolean isUnivalTree(TreeNode root, int num) {
        if(root == null) return true;
        if(root.val != num) return false;
        if(!isUnivalTree(root.left, num)) return false;
        return isUnivalTree(root.right, num);
    }
}
