// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
// The same repeated number may be chosen from candidates unlimited number of times.
//
// Note:
//
//
// 	All numbers (including target) will be positive integers.
// 	The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//   [7],
//   [2,2,3]
// ]
//
//
// Example 2:
//
//
// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]
//
//


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        kkkkk(list, temp, candidates, target, 0);
        return list;
    }
    
    public void kkkkk(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int start){
        if(target == 0){
            list.add(new ArrayList<Integer>(temp));
        }else if(target > 0){
            for(int i = start; i < candidates.length && candidates[i] <= target; i++){
                temp.add(candidates[i]);
                kkkkk(list, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
