// Given a non-empty binary tree, find the maximum path sum.
//
// For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//  
// Example 1:
//
//
// Input: root = [1,2,3]
// Output: 6
//
//
// Example 2:
//
//
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the tree is in the range [0, 3 * 104].
// 	-1000 <= Node.val <= 1000
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

    /**
     * 直接
     */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum(root, false);
        return  max;
    }

    public int maxPathSum(TreeNode root, boolean isSinglePath) {
        if(root == null) return 0;
        int left = maxPathSum(root.left, true);
        int right = maxPathSum(root.right, true);
        max = Math.max(max, root.val);
        int resIsSingle = root.val+ Math.max(left, right);
        max = Math.max(max, resIsSingle);
        resIsSingle = Math.max(root.val, resIsSingle);
        int res = left+right+root.val;
        max = Math.max(max, res);
        res = Math.max(res, resIsSingle);
        if(isSinglePath){
            return resIsSingle;
        }else {
            return res;
        }
    }
}
