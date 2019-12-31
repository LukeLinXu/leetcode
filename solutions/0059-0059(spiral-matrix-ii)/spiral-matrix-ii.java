// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// Example:
//
//
// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
//
//


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int direct = 1;
        for(int i = 1; i <= n*n; i++){
            result[x][y] = i;
            switch(direct){
                case 1:
                    if(y+1<n && result[x][y+1]==0){
                        y++;
                    }else{
                        direct = 2;
                        x++;
                    }
                    break;
                case 2:
                    if(x+1<n && result[x+1][y]==0){
                        x++;
                    }else{
                        direct = 3;
                        y--;
                    }
                    break;
                case 3:
                    if(y-1>-1 && result[x][y-1]==0){
                        y--;
                    }else{
                        direct = 4;
                        x--;
                    }
                    break;
                case 4:
                    if(x-1>-1 && result[x-1][y]==0){
                        x--;
                    }else{
                        direct = 1;
                        y++;
                    }
                    break;
            }
        }
        return result;
    }
}
