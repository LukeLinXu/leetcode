// Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
//
//  
// Example 1:
//
//
// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
//
// Example 2:
//
//
// Input: arr = [1,2]
// Output: false
//
//
// Example 3:
//
//
// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
//
//
//  
// Constraints:
//
//
// 	1 <= arr.length <= 1000
// 	-1000 <= arr[i] <= 1000
//
//


class Solution {
    /**
     * 直接
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int p = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int value: map.values()){
            set.add(value);
        }
        return set.size() == map.size();
    }
}
