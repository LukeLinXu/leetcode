// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// Example:
//
//
// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
//
// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
//
//
//  
// Constraints:
//
//
// 	board and word consists only of lowercase and uppercase English letters.
// 	1 <= board.length <= 200
// 	1 <= board[i].length <= 200
// 	1 <= word.length <= 10^3
//
//


public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(exist(board, w, i, j, 0)) return true;;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, char[] w, int i, int j, int k){
        if(k == w.length) return true;
        if(i < 0 || i == board.length || j < 0 || j == board[i].length) return false;
        if(board[i][j] != w[k]) return false;
        boolean p = false;
        board[i][j] ^= 256;
        p = exist(board, w, i+1, j, k + 1) ||
             exist(board, w, i-1, j, k + 1) ||
             exist(board, w, i, j+1, k + 1) ||
             exist(board, w, i, j-1, k + 1);
        board[i][j] ^= 256;
        return p;
    }
}
