// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int post = postorder.length;
        int in = inorder.length;
        for(int i = 0; i < in; i++){
            map.put(inorder[i], i);
        }
        return build(postorder, 0, post - 1, inorder, 0, in - 1);
    }

    private TreeNode build(int[] postorder, int s0, int e0, int[] inorder, int s1, int e1){
        if(s0 > e0 || s1 > e1){
            return null;
        }
        int mid = postorder[e0];
        TreeNode treeNode = new TreeNode(mid);
        int pos = map.get(mid);
        treeNode.left = build(postorder, s0, pos - s1+s0-1, inorder, s1, pos - 1);
        treeNode.right = build(postorder, pos - s1+s0, e0-1, inorder, pos+1, e1);
        return treeNode;
    }
}
