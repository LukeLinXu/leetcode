// Return the root node of a binary search tree that matches the given preorder traversal.
//
// (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
//
//  
//
// Example 1:
//
//
// Input: [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]
//
//
//
//  
//
// Note: 
//
//
// 	1 <= preorder.length <= 100
// 	The values of preorder are distinct.
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
     * 更有意思的解法，设置上限来返回TreeNode, 并且i的增加正好符合先左后后的规律
     */

    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
    
    
    /**
     * 要仔细考虑没有找到比parent更大的值
     */
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     return getNode(preorder, 0, preorder.length - 1);
    // }
    public TreeNode getNode(int[] preorder, int start, int end){
        if(end < start || start<0) return null;

        int parent = preorder[start];
        int rightParentIndex = -1;
        TreeNode treeNode = new TreeNode(parent);
        for(int i = start + 1; i <= end; i++){
            if(preorder[i] > parent){
                rightParentIndex = i;
                break;
            }
        }
        if(rightParentIndex == -1){
            treeNode.right = null;
            treeNode.left = getNode(preorder, start+1, end);
        }else {
            treeNode.right = getNode(preorder, rightParentIndex, end);
            treeNode.left = getNode(preorder, start + 1, rightParentIndex - 1);
        }
        return treeNode;
    }
}
