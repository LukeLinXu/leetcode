// You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
//
// There is at least one empty seat, and at least one person sitting.
//
// Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
//
// Return that maximum distance to the closest person.
//
//  
// Example 1:
//
//
// Input: seats = [1,0,0,0,1,0,1]
// Output: 2
// Explanation: 
// If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
// If Alex sits in any other open seat, the closest person has distance 1.
// Thus, the maximum distance to the closest person is 2.
//
//
// Example 2:
//
//
// Input: seats = [1,0,0,0]
// Output: 3
// Explanation: 
// If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
// This is the maximum distance possible, so the answer is 3.
//
//
// Example 3:
//
//
// Input: seats = [0,1]
// Output: 1
//
//
//  
// Constraints:
//
//
// 	2 <= seats.length <= 2 * 104
// 	seats[i] is 0 or 1.
// 	At least one seat is empty.
// 	At least one seat is occupied.
//
//


class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int l = 0;
        int r = len - 1;
        int max0 = 0;
        while (l <= r && seats[l] == 0){
            l++;
        }
        max0 = Math.max(max0, 2*l);
        while (l <= r && seats[r] == 0){
            r--;
        }
        max0 = Math.max(max0, 2*(len - 1- r));
        
        int start = l;
        int end = r;
        if(start != end){
            while (true){
                while (start <= r && seats[start] == 1){
                    start++;
                }
                end = start;
                while (end <= r && seats[end] == 0){
                    end++;
                }
                max0 = Math.max(max0, end - start);
                if(start >= r || end >= r) break;
                start = end;
            }
        }

        return (max0+1)/2;
    }
}
