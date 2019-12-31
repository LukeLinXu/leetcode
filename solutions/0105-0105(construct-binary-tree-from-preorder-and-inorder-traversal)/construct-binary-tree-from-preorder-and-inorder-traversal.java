// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
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
public class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pre = preorder.length;
        int in = inorder.length;
        for(int i = 0; i < in; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, pre - 1, inorder, 0, in - 1);
    }

    private TreeNode build(int[] preorder, int s0, int e0, int[] inorder, int s1, int e1){
        if(s0 > e0 || s1 > e1){
            return null;
        }
        int mid = preorder[s0];
        TreeNode treeNode = new TreeNode(mid);
        int pos = map.get(mid);
        treeNode.left = build(preorder, s0 + 1, pos - s1+s0, inorder, s1, pos - 1);
        treeNode.right = build(preorder, pos - s1+s0+1, e0, inorder, pos+1, e1);
        return treeNode;
    }
}
