// Find the sum of all left leaves in a given binary tree.
//
// Example:
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        runNode(root);
        return sum;
    }
    public void runNode(TreeNode node){
        if(node != null){
            sum+=checkTree(node);
            runNode(node.left);
            runNode(node.right);
        }
    }
    public int checkTree(TreeNode node){
        if(node == null) return 0;
        if(node.left != null && node.left.left == null && node.left.right == null){
            return node.left.val;
        }else {
            return 0;
        }
    }
}
