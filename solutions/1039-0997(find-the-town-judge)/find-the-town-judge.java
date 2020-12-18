// In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
//
// If the town judge exists, then:
//
//
// 	The town judge trusts nobody.
// 	Everybody (except for the town judge) trusts the town judge.
// 	There is exactly one person that satisfies properties 1 and 2.
//
//
// You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
//
// If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
//
//  
// Example 1:
// Input: N = 2, trust = [[1,2]]
// Output: 2
// Example 2:
// Input: N = 3, trust = [[1,3],[2,3]]
// Output: 3
// Example 3:
// Input: N = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1
// Example 4:
// Input: N = 3, trust = [[1,2],[2,3]]
// Output: -1
// Example 5:
// Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
// Output: 3
//
//  
// Constraints:
//
//
// 	1 <= N <= 1000
// 	0 <= trust.length <= 10^4
// 	trust[i].length == 2
// 	trust[i] are all different
// 	trust[i][0] != trust[i][1]
// 	1 <= trust[i][0], trust[i][1] <= N
//


class Solution {
    /**
     * 人才啊，精妙
     */
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
    
    public int findJudgeMy(int N, int[][] trust) {
        if(N == 1 && trust.length == 0) return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int[] temp: trust){
            int value = map.getOrDefault(temp[1], 0)+1;
            map.put(temp[1], value);
            set.add(temp[0]);
        }
        for(int key: map.keySet()){
            if(map.get(key) == N-1 && !set.contains(key)){
                return key;
            }
        }
        return -1;
    }
}
