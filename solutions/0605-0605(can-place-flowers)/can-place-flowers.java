// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
//
//  
// Example 1:
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true
// Example 2:
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false
//
//  
// Constraints:
//
//
// 	1 <= flowerbed.length <= 2 * 104
// 	flowerbed[i] is 0 or 1.
// 	There are no two adjacent flowers in flowerbed.
// 	0 <= n <= flowerbed.length
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
