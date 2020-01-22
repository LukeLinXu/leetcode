// Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
// Example 1:
//
//
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7
//
// Target = 9
//
// Output: True
//
//
//  
//
// Example 2:
//
//
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7
//
// Target = 28
//
// Output: False
//
//
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }
    
    public boolean findTarget(TreeNode root, int k, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k, set) || findTarget(root.right, k, set);
    }
}
