// Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//
// Return the intersection of these two interval lists.
//
// (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
//
//
//  
//
// Example 1:
//
//
//
//
// Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
// Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//
//
//  
//
// Note:
//
//
// 	0 <= A.length < 1000
// 	0 <= B.length < 1000
// 	0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
//
//
//


class Solution {
    /**
     * 直接
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> list = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length){
            boolean p = intervalIntersection(A[indexA], B[indexB], list);
            if(p){
                indexA++;
            }else {
                indexB++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public boolean intervalIntersection(int[] A, int[] B, ArrayList<int[]> list) {
        int a0 = A[0];
        int a1 = A[1];
        int b0 = B[0];
        int b1 = B[1];

        if(a0 >= b0 && a1 <= b1){
            list.add(new int[]{a0, a1});
            return true;
        }else if(b0 >= a0 && b1 <= a1){
            list.add(new int[]{b0, b1});
            return false;
        }else if(a0>=b0 && a0 <=b1){
            list.add(new int[]{a0, b1});
            return false;
        }else if(b0>=a0 && b0 <=a1){
            list.add(new int[]{b0, a1});
            return true;
        }else {
            return a1 < b0;
        }
    }
}
