// Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
//
// Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
//
//  
// Example 1:
// Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
// Output: 1
//
//  
// Constraints:
//
//
// 	1 <= dominoes.length <= 40000
// 	1 <= dominoes[i][j] <= 9
//


class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] temp : dominoes){
            int x = temp[0];
            int y = temp[1];
            int value = (x>y)? 10*x+y : 10*y+x;
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        int total = 0;
        for(int count: map.values()){
            if(count > 1){
                total+=((count*(count-1))/2);
            }
        }
        return total;
    }
}
