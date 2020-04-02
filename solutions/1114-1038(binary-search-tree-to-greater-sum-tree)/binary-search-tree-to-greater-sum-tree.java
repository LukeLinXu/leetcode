// Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
//
// As a reminder, a binary search tree is a tree that satisfies these constraints:
//
//
// 	The left subtree of a node contains only nodes with keys less than the node's key.
// 	The right subtree of a node contains only nodes with keys greater than the node's key.
// 	Both the left and right subtrees must also be binary search trees.
//
//
//  
//
// Example 1:
//
//
//
//
// Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
// Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//
//
//
//  
//
//
// Constraints:
//
//
// 	The number of nodes in the tree is between 1 and 100.
// 	Each node will have value between 0 and 100.
// 	The given tree is a binary search tree.
//
//
//
//
// Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
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
