// Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
//
//  
// Example 1:
//
//
// Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
// Output: 32
//
//
// Example 2:
//
//
// Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
// Output: 23
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the tree is in the range [1, 2 * 104].
// 	1 <= Node.val <= 105
// 	1 <= low <= high <= 105
// 	All Node.val are unique.
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
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        return getValue(root, L, R);
    }

    public int getValue(TreeNode root, int L, int R){
        if(root == null) return 0;
        if(root.val >= L && root.val <= R){
            return root.val + getValue(root.left, L, R) +getValue(root.right, L, R);
        }else if(root.val < L){
            return getValue(root.right, L, R);
        }else {
            return getValue(root.left, L, R);
        }
    }
}
