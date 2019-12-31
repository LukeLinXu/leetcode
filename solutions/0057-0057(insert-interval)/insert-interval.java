// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
// Example 1:
//
//
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
//
//
// Example 2:
//
//
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
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
