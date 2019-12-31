// On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
//
// The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
//
// Return the number of pawns the rook can capture in one move.
//
//  
//
// Example 1:
//
//
//
//
// Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
// Output: 3
// Explanation: 
// In this example the rook is able to capture all the pawns.
//
//
// Example 2:
//
//
//
//
// Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
// Output: 0
// Explanation: 
// Bishops are blocking the rook to capture any pawn.
//
//
// Example 3:
//
//
//
//
// Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
// Output: 3
// Explanation: 
// The rook can capture the pawns at positions b5, d6 and f5.
//
//
//  
//
// Note:
//
//
// 	board.length == board[i].length == 8
// 	board[i][j] is either 'R', '.', 'B', or 'p'
// 	There is exactly one cell with board[i][j] == 'R'
//
//


class Solution {
    public int numRookCaptures(char[][] board) {
        int x = -1;
        int y = -1;
        for(int i = 0; i < board.length; i++){
            boolean found = false;
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'R'){
                    x = i;
                    y = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        if(x == -1) return 0;
        int result = 0;
        for(int i = x; i < board.length; i++){
            if(board[i][y] == 'B') break;
            if(board[i][y] == 'p'){
                result++;
                break;
            }
        }

        for(int i = x; i >= 0; i--){
            if(board[i][y] == 'B') break;
            if(board[i][y] == 'p'){
                result++;
                break;
            }
        }

        for(int i = y; i < board[x].length; i++){
            if(board[x][i] == 'B') break;
            if(board[x][i] == 'p'){
                result++;
                break;
            }
        }

        for(int i = y; i >= 0; i--){
            if(board[x][i] == 'B') break;
            if(board[x][i] == 'p'){
                result++;
                break;
            }
        }
        
        return result;
    }
}
