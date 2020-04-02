// Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//
//
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//  
// Constraints:
//
//
// 	Both of the given trees will have between 1 and 200 nodes.
// 	Both of the given trees will have values between 0 and 200
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> listL = new ArrayList<>();
        List<Integer> listR = new ArrayList<>();
        leafSimilar(root1, listL);
        leafSimilar(root2, listR);
        return listL.equals(listR);
    }
    public void leafSimilar(TreeNode root, List<Integer> list) {
        if(root != null){
            if(root.left == null && root.right == null){
                list.add(root.val);
            }else {
                leafSimilar(root.left, list);
                leafSimilar(root.right, list);
            }
        }
    }
}
