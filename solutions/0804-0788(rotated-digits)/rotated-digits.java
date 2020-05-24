// X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
//
// A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
//
// Now given a positive number N, how many numbers X from 1 to N are good?
//
//
// Example:
// Input: 10
// Output: 4
// Explanation: 
// There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
// Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
//
//
// Note:
//
//
// 	N  will be in range [1, 10000].
//
//


class Solution {
    /**
     * 很可怕的解法，随着i增大，dp慢慢被填满，值得仔细看看
     */    
    public int rotatedDigits(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * 初始的想法
     */
    // public int rotatedDigits(int N) {
    //     HashMap<Character, Character> map = new HashMap<>();
    //     map.put('0', '0');
    //     map.put('1', '1');
    //     map.put('2', '5');
    //     map.put('5', '2');
    //     map.put('6', '9');
    //     map.put('8', '8');
    //     map.put('9', '6');
    //     int count = 0;
    //     for(int i = 1; i <=N;i++){
    //         String s = String.valueOf(i);
    //         boolean validChar = true;
    //         for(char c: s.toCharArray()){
    //             if(!map.containsKey(c)){
    //                 validChar = false;
    //                 break;
    //             }
    //         }
    //         if(validChar){
    //             for(char c: s.toCharArray()){
    //                 if(c != map.get(c)){
    //                     count++;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }
}