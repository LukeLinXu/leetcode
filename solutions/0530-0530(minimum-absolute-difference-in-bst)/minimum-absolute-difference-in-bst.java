// Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
//
// Example:
//
//
// Input:
//
//    1
//     \
//      3
//     /
//    2
//
// Output:
// 1
//
// Explanation:
// The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
//
//
//  
//
// Note: There are at least two nodes in this BST.


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
     * BTS
     */
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
    /**
     * 第一想法，适用于任何树，包括BT
     */
    public int getMinimumDifference_ddd(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getMinimumDifference(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < list.size() - 1; i++){
            min = Math.min(min, list.get(i+1)-list.get(i));
        }
        return min;
    }

    public void getMinimumDifference(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        getMinimumDifference(root.left, list);
        getMinimumDifference(root.right, list);
    }
}
