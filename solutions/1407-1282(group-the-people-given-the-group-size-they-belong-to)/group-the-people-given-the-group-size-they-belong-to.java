// There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.
//
// You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution. 
//
//  
// Example 1:
//
//
// Input: groupSizes = [3,3,3,3,3,1,3]
// Output: [[5],[0,1,2],[3,4,6]]
// Explanation: 
// Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
//
//
// Example 2:
//
//
// Input: groupSizes = [2,1,3,3,3,2]
// Output: [[1],[0,5],[2,3,4]]
//
//
//  
// Constraints:
//
//
// 	groupSizes.length == n
// 	1 <= n <= 500
// 	1 <= groupSizes[i] <= n
//
//


class Solution {
    /**
     * 直接, 但是逻辑要严谨，不要忘记最后必须都处理干净
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            int groupSize = groupSizes[i];
            if(map.containsKey(groupSize)){
                ArrayList<Integer> integers = map.get(groupSize);
                if(integers.size() == groupSize - 1){
                    integers.add(i);
                    list.add(integers);
                    map.remove(groupSize);
                }else {
                    integers.add(i);
                }
            }else {
                if(groupSize == 1){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    list.add(temp);
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.put(groupSize, temp);
                }    
            }
        }
        return list;
    }
}
