// Given a binary tree, return the sum of values of its deepest leaves.
//  
// Example 1:
//
//
//
//
// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the tree is between 1 and 10^4.
// 	The value of nodes is between 1 and 100.
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
    public int deepestLeavesSum(TreeNode root) {
        return getPair(root, 0).y;
    }

    public Pair getPair(TreeNode root, int max){
        if(root.left == null && root.right == null){
            return new Pair(max+1, root.val);
        }else if(root.left != null && root.right == null){
            return getPair(root.left, max+1);
        }else if(root.left == null && root.right != null){
            return getPair(root.right, max + 1);
        }else {
            Pair left = getPair(root.left, max + 1);
            Pair right = getPair(root.right, max + 1);
            if(left.x > right.x){
                return left;
            }else if(left.x < right.x){
                return right;
            }else {
                return new Pair(left.x, left.y+right.y);
            }
        }
    }

    public class Pair{
        private final int x;
        private final int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
