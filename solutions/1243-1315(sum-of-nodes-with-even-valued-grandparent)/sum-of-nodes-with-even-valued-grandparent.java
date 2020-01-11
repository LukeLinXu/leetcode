// Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
//
// If there are no nodes with an even-valued grandparent, return 0.
//
//  
// Example 1:
//
//
//
//
// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 18
// Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the tree is between 1 and 10^4.
// 	The value of nodes is between 1 and 100.
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
     *   将TreeNode 和parent, grandParent 联系在一起，写一个method.
     */    
    
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1, 1);
    }

    public int helper(TreeNode node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }
    
    /**
     * 直接
     */

//     int sum = 0;
//     public int sumEvenGrandparent(TreeNode root) {
//         if(root == null) return 0;
//         if(root.val%2 == 0){
//             if(root.left != null){
//                 if(root.left.left != null){
//                     sum+=root.left.left.val;
//                 }
//                 if(root.left.right != null){
//                     sum+=root.left.right.val;
//                 }
//             }

//             if(root.right != null){
//                 if(root.right.left != null){
//                     sum+=root.right.left.val;
//                 }
//                 if(root.right.right != null){
//                     sum+=root.right.right.val;
//                 }
//             }
//         }

//         sumEvenGrandparent(root.left);
//         sumEvenGrandparent(root.right);
//         return sum;
//     }
}
