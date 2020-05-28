// Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
//
// Each person may dislike some other people, and they should not go into the same group. 
//
// Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
//
// Return true if and only if it is possible to split everyone into two groups in this way.
//
//  
//
//
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
// Output: true
// Explanation: group1 [1,4], group2 [2,3]
//
//
//
// Example 2:
//
//
// Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
// Output: false
//
//
//
// Example 3:
//
//
// Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
// Output: false
//
//
//  
//
// Note:
//
//
// 	1 <= N <= 2000
// 	0 <= dislikes.length <= 10000
// 	1 <= dislikes[i][j] <= N
// 	dislikes[i][0] < dislikes[i][1]
// 	There does not exist i != j for which dislikes[i] == dislikes[j].
//
//
//
//
//


class Solution {
    /**
     * 厉害了，graph
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean[][] g = new boolean[N][N];
        for (int[] d : dislikes) {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++)
            if (colors[i] == 0 && !paint(i, 1, colors, g))
                return false;
        return true;
    }

    boolean paint(int u, int color, int[] colors, boolean[][] g) {
        if (colors[u] != 0)
            return colors[u] == color;
        colors[u] = color;
        for (int v = 0; v < colors.length; v++)
            if (g[u][v] && !paint(v, -color, colors, g))
                return false;
        return true;
    }
}
