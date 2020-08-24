// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//  
// Example 1:
//
//
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//
// Example 2:
//
//
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
//
//
// Example 3:
//
//
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
//
// Example 4:
//
//
// Input: prices = [1]
// Output: 0
//
//
//  
// Constraints:
//
//
// 	1 <= prices.length <= 105
// 	0 <= prices[i] <= 105
//
//


public class Solution {
    public static int maxProfit(int[] list) {
        if(list == null) return 0;
        int size = list.length;
        if(size == 0 || size == 1) return 0;
        boolean isFindingMin = true;
        int temp = list[0];
        int min = -1;
        int startPosition = 0;
        ArrayList<Integer> arrayListMax = new ArrayList<>();
        ArrayList<Integer> arrayListMin = new ArrayList<>();

        for(int i = 1; i <= size - 1; i++){
            if(temp > list[i]){
                isFindingMin = true;
                temp = list[i - 1];
                startPosition = i;
                break;
            }else if(temp < list[i]){
                min = temp;
                temp = list[i - 1];
                isFindingMin = false;
                startPosition = i;
                break;
            }
        }

        for(int i = startPosition; i <= size - 1; i++){
            if(isFindingMin){
                if(temp < list[i]){
                    min = temp;
                    isFindingMin = false;
                }
            }else{
                if(temp > list[i]){
                    arrayListMax.add(temp);
                    arrayListMin.add(min);
                    isFindingMin = true;
                }
            }
            temp = list[i];
            if(i == size - 1 && !isFindingMin){
                arrayListMax.add(temp);
                arrayListMin.add(min);
            }
        }

        int count = 0;
        for(int i = 0; i < arrayListMax.size(); i++){
            int i1 = firstProfit(arrayListMax, arrayListMin, i) + secondProfit(arrayListMax, arrayListMin, i);
            if(i1 > count) count = i1;
        }

        return count;
    }

    public static int secondProfit(ArrayList<Integer> listMax, ArrayList<Integer> listMin, int position){
        if(position == listMin.size() - 1) return 0;
        position = position + 1;
        int count = 0;
        for(int i = position; i < listMax.size(); i++){
            for(int j = position; j <= i; j++){
                int i1 = listMax.get(i) - listMin.get(j);
                if(count <= i1) count = i1;
            }
        }
        return count;
    }

    public static int firstProfit(ArrayList<Integer> listMax, ArrayList<Integer> listMin, int position){
        int max = listMax.get(position);
        int min = max;
        for(int i = 0; i <= position; i++){
            if(min >= listMin.get(i)) min = listMin.get(i);
        }
        return max - min;
    }
}
