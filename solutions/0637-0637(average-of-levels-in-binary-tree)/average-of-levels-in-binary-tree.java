// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//
// Example 1:
//
// Input:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//
//
//
// Note:
//
// The range of node's value is in the range of 32-bit signed integer.
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
     * BFS 有点意思
     */    
    public List < Double > averageOfLevels(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
    /**
     * 我的第一反应：DFS
     */
    Map<Integer, Integer> map = new HashMap<>();
    public List<Double> averageOfLevels_dddd(TreeNode root) {
        List<Double> list =  new LinkedList();
        averageOfLevels(root, list, 0);
        return list;
    }

    public void averageOfLevels(TreeNode root, List<Double> list, int level) {
        if(root == null) return;
        if(list.size() > level){
            Integer integer = map.get(level);
            list.set(level, (list.get(level)* integer +root.val)/(integer +1));
            map.put(level, integer +1);
        }else {
            list.add(root.val*1.0);
            map.put(level, 1);
        }
        averageOfLevels(root.left, list, level+1);
        averageOfLevels(root.right, list, level+1);
    }
}
