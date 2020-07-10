// Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
//
// The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
//
// Example 1:
//
//
// Input: 
//
//            1
//          /   \
//         3     2
//        / \     \  
//       5   3     9 
//
// Output: 4
// Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
//
//
// Example 2:
//
//
// Input: 
//
//           1
//          /  
//         3    
//        / \       
//       5   3     
//
// Output: 2
// Explanation: The maximum width existing in the third level with the length 2 (5,3).
//
//
// Example 3:
//
//
// Input: 
//
//           1
//          / \
//         3   2 
//        /        
//       5      
//
// Output: 2
// Explanation: The maximum width existing in the second level with the length 2 (3,2).
//
//
// Example 4:
//
//
// Input: 
//
//           1
//          / \
//         3   2
//        /     \  
//       5       9 
//      /         \
//     6           7
// Output: 8
// Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
//
//
//
//
// Note: Answer will in the range of 32-bit signed integer.
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
    HashMap<Integer, Integer> max = new HashMap<>();
    HashMap<Integer, Integer> min = new HashMap<>();
    int widthOfBinaryTreeRes = 0;
    public int widthOfBinaryTree(TreeNode root) {
        widthOfBinaryTreeHelper(root, 0, 0);
        return widthOfBinaryTreeRes+1;
    }

    public void widthOfBinaryTreeHelper(TreeNode root, int layer, int position) {
        if(root == null) return;
        int maxT = max.getOrDefault(layer, position);
        max.put(layer, Math.max(position, maxT));
        int minT = min.getOrDefault(layer, position);
        min.put(layer, Math.min(minT, position));
        widthOfBinaryTreeRes = Math.max(widthOfBinaryTreeRes, max.get(layer) - min.get(layer));
        widthOfBinaryTreeHelper(root.left, layer+1, 2*position);
        widthOfBinaryTreeHelper(root.right, layer+1, 2*position+1);
    }
}
