// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//  
//
// Example 1:
//
//
// Input: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// Output: 1
//
// Example 2:
//
//
// Input: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// Output: 3
//
//
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
//
//  
// Constraints:
//
//
// 	The number of elements of the BST is between 1 to 10^4.
// 	You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
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
    int globalK = 0;
    public int kthSmallest(TreeNode root, int k) {
        globalK = k;
        return kthSmallest(root);
    }
    public Integer kthSmallest(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode bottom = root;
        stack.push(bottom);
        while (bottom.left != null){
            bottom = bottom.left;
            stack.push(bottom);
        }
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            globalK--;
            if(globalK == 0){
                return pop.val;
            }else {
                Integer res = kthSmallest(pop.right);
                if(res != null) return res;
            }
        }
        return null;
    }
}
