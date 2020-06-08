// You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
//
//
//
//
//  
//
// Example 1:
//
//
// Input: amount = 5, coins = [1, 2, 5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
//
//
// Example 2:
//
//
// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
//
//
// Example 3:
//
//
// Input: amount = 10, coins = [10] 
// Output: 1
//
//
//  
//
// Note:
//
// You can assume that
//
//
// 	0 <= amount <= 5000
// 	1 <= coin <= 5000
// 	the number of coins is less than 500
// 	the answer is guaranteed to fit into signed 32-bit integer
//
//


class Solution {
    /**
     * 虽然是自己做的，还是废了挺多功夫
     */
    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int len = coins.length;
        int[] times = new int[len];
        for(int i = 0; i < len; i++){
            times[i] = amount/coins[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return change(amount, 0, coins, times, len, map);
    }

    public static int change(int amount, int position, int[] coins, int[] times, int len, HashMap<Integer, Integer> map) {
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(position == len - 1){
            boolean k = amount%coins[len - 1 - position] == 0;
            return k?1:0;
        }else if(position > len - 1){
            return 0;
        }
        if(map.containsKey(1000*amount+position)){
            return map.get(1000*amount+position);
        }
        int count = 0;
        for(int i = 0; i <= times[len - 1 - position]; i++){
            count += change(amount - i * coins[len - 1 - position], position+1, coins, times, len, map);
        }
        map.put(1000*amount+ position, count);
        return count;
    }
}
