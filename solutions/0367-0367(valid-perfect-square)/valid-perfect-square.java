// Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
// Note: Do not use any built-in library function such as sqrt.
//
// Example 1:
//
//
//
// Input: 16
// Output: true
//
//
//
// Example 2:
//
//
// Input: 14
// Output: false
//
//
//


class Solution {
    /**
     * 直接
     */
    public boolean isPerfectSquare(int num) {
        int length = String.valueOf(num).length();
        length++;
        length = length/2;
        long left = 0;
        long right = (long) Math.pow(10, length);
        while (true){
            if(left+1 == right){
                return left*left == num || right*right == num;
            }
            long mid = (left+right)/2;
            long res = mid*mid;
            if(num==res){
                return true;
            }else if(num>res){
                left = mid;
            }else {
                right = mid;
            }
        }
    }
}
