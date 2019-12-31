// Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
//
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
//


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start - o2.start == 0){
                    return o1.end - o2.end;
                }else {
                    return o1.start - o2.start;
                }
            }
        });
        int i = 0;
        while (i < intervals.size() - 1){
            if(intervals.get(i+1).start <= intervals.get(i).end){
                if(intervals.get(i+1).end > intervals.get(i).end){
                    intervals.get(i).end = intervals.get(i+1).end;
                }
                intervals.remove(i+1);
            }else {
                i++;
            }
        }
        return intervals;
    }
}
