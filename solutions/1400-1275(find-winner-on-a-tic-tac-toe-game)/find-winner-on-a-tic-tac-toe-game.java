// Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
//
// Here are the rules of Tic-Tac-Toe:
//
//
// 	Players take turns placing characters into empty squares (" ").
// 	The first player A always places "X" characters, while the second player B always places "O" characters.
// 	"X" and "O" characters are always placed into empty squares, never on filled ones.
// 	The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
// 	The game also ends if all squares are non-empty.
// 	No more moves can be played if the game is over.
//
//
// Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.
//
// Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".
//
// You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
//
//  
// Example 1:
//
//
// Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
// Output: "A"
// Explanation: "A" wins, he always plays first.
// "X  "    "X  "    "X  "    "X  "    "X  "
// "   " -> "   " -> " X " -> " X " -> " X "
// "   "    "O  "    "O  "    "OO "    "OOX"
//
//
// Example 2:
//
//
// Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
// Output: "B"
// Explanation: "B" wins.
// "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
// "   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
// "   "    "   "    "   "    "   "    "   "    "O  "
//
//
// Example 3:
//
//
// Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
// Output: "Draw"
// Explanation: The game ends in a draw since there are no moves to make.
// "XXO"
// "OOX"
// "XOX"
//
//
// Example 4:
//
//
// Input: moves = [[0,0],[1,1]]
// Output: "Pending"
// Explanation: The game has not finished yet.
// "X  "
// " O "
// "   "
//
//
//  
// Constraints:
//
//
// 	1 <= moves.length <= 9
// 	moves[i].length == 2
// 	0 <= moves[i][j] <= 2
// 	There are no repeated elements on moves.
// 	moves follow the rules of tic tac toe.
//


class Solution {
    /**
     * 直接
     */
    public String tictactoe(int[][] moves) {
        int[] grid = new int[9];
        for(int i = 0; i < moves.length; i++){
            grid[moves[i][0]*3+moves[i][1]] = (i%2== 0 ? 1:-1);
        }

        if(isWinner(grid, 1)) return "A";
        if(isWinner(grid, -1)) return "B";
        if(moves.length == 9) return "Draw";
        return "Pending";
    }

    public boolean isWinner(int[] grid, int expect){
        if(grid[0] == expect && grid[0] == grid[1] && grid[0] == grid[2]) return true;
        if(grid[3] == expect && grid[3] == grid[4] && grid[3] == grid[5]) return true;
        if(grid[6] == expect && grid[6] == grid[7] && grid[6] == grid[8]) return true;

        if(grid[0] == expect && grid[0] == grid[3] && grid[0] == grid[6]) return true;
        if(grid[1] == expect && grid[1] == grid[4] && grid[1] == grid[7]) return true;
        if(grid[2] == expect && grid[2] == grid[5] && grid[2] == grid[8]) return true;

        if(grid[0] == expect && grid[0] == grid[4] && grid[0] == grid[8]) return true;
        if(grid[2] == expect && grid[2] == grid[4] && grid[2] == grid[6]) return true;

        return false;
    }

}
