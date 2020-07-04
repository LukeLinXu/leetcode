// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its bottom-up level order traversal as:
//
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        levelOrderBottomHelper(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    public void levelOrderBottomHelper(TreeNode root, List<List<Integer>> list, int pos) {
        if(root == null) return;
        if(list.size() < pos+1){
            list.add(new ArrayList<>());
        }
        list.get(pos).add(root.val);
        levelOrderBottomHelper(root.left, list, pos+1);
        levelOrderBottomHelper(root.right, list, pos+1);
    }
}
