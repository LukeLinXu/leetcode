// In a deck of cards, each card has an integer written on it.
//
// Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
//
//
// 	Each group has exactly X cards.
// 	All the cards in each group have the same integer.
//
//
//  
// Example 1:
//
//
// Input: deck = [1,2,3,4,4,3,2,1]
// Output: true
// Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//
//
// Example 2:
//
//
// Input: deck = [1,1,1,2,2,2,3,3]
// Output: false´
// Explanation: No possible partition.
//
//
// Example 3:
//
//
// Input: deck = [1]
// Output: false
// Explanation: No possible partition.
//
//
// Example 4:
//
//
// Input: deck = [1,1]
// Output: true
// Explanation: Possible partition [1,1].
//
//
// Example 5:
//
//
// Input: deck = [1,1,2,2,2,2]
// Output: true
// Explanation: Possible partition [1,1],[2,2],[2,2].
//
//
//  
// Constraints:
//
//
// 	1 <= deck.length <= 10^4
// 	0 <= deck[i] < 10^4
//
//


class Solution {
// public boolean hasGroupsSizeX(int[] deck) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i : deck){
//             map.put(i, map.getOrDefault(i, 0)+1);
//         }
//         Integer[] integers = map.values().toArray(new Integer[map.values().size()]);
//         Arrays.sort(integers);
//         if(integers[0] == 1) return false;
//         if(integers.length == 1) return true;
//         int temp = maxNumber(integers[0], integers[1]);
//         if(temp == 1) return false;
//         for(int i = 2; i < integers.length; i++){
//             temp = maxNumber(temp, integers[i]);
//             if(temp == 1) return false;
//         }
//         return temp != 1;
//     }

//     int maxNumber(int m, int n) {
//         int temp;
//         if (n > m) {
//             temp = n;
//             n = m;
//             m = temp;
//         }
//         if (m % n == 0) {
//             return n;
//         }
//         return maxNumber(m - n, n);
//     }
    

    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

}
