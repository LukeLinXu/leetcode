// Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//
// Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
//
// Example 1:
//
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: True
//
//
//
// Example 2:
//
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: False
//
//
//
// Note:
//
// The input array won't violate no-adjacent-flowers rule.
// The input array size is in the range of [1, 20000].
// n is a non-negative integer which won't exceed the input array size.
//
//


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0) return true;
        if(len == 0) return false;
        if(len == 1){
            return flowerbed[0] == 0;
        }
        if(len == 2){
            if(n == 2) return false;
            if(flowerbed[0] == 1 || flowerbed[1] == 1){
                return false;
            }
            return true;
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            n--;
            if(n == 0) return true;
        }

        if(flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0){
            flowerbed[len - 1] = 1;
            n--;
            if(n == 0) return true;
        }

        for(int i = 1; i < flowerbed.length - 1; i++){
            if(flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
                i++;
            }
        }
        return false;
    }
}
