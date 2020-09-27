// Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
//
// As a reminder, a binary search tree is a tree that satisfies these constraints:
//
//
// 	The left subtree of a node contains only nodes with keys less than the node's key.
// 	The right subtree of a node contains only nodes with keys greater than the node's key.
// 	Both the left and right subtrees must also be binary search trees.
//
//
// Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
//
//  
// Example 1:
//
//
// Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
// Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//
//
// Example 2:
//
//
// Input: root = [0,null,1]
// Output: [1,null,1]
//
//
// Example 3:
//
//
// Input: root = [1,0,2]
// Output: [3,3,2]
//
//
// Example 4:
//
//
// Input: root = [3,2,4,1]
// Output: [7,9,4,10]
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the tree is in the range [1, 100].
// 	0 <= Node.val <= 100
// 	All the values in the tree are unique.
// 	root is guaranteed to be a valid binary search tree.
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
import java.util.*;
class Solution {
    
        
    /**
     * 精妙啊
     */
    int pre = 0;
    public TreeNode bstToGst(TreeNode root){
        if(root.right != null) bstToGst(root.right);
        pre = root.val = root.val + pre;
        if(root.left != null) bstToGst(root.left);
        return root;
    }
    
    /**
     * 简单粗暴
     */
    // public TreeNode bstToGst(TreeNode root) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     fillList(root, list);
    //     list.sort(new Comparator<Integer>() {
    //         @Override
    //         public int compare(Integer o1, Integer o2) {
    //             return o2 - o1;
    //         }
    //     });
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int count = 0;
    //     for (Integer integer : list) {
    //         count += integer;
    //         map.put(integer, count);
    //     }
    //     fillNode(root, map);
    //     return root;
    // }
    
    public void fillNode(TreeNode node, HashMap<Integer, Integer> map){
        node.val = map.get(node.val);
        if(node.left != null) fillNode(node.left, map);
        if(node.right != null) fillNode(node.right, map);
    }
    
    public void fillList(TreeNode node, ArrayList<Integer> list){
        list.add(node.val);
        if(node.left != null) fillList(node.left, list);
        if(node.right != null) fillList(node.right, list);
    }
}
