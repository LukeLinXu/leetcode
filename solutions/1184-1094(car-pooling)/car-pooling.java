// You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
//
// Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.
//
// Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 
//
//  
//
// Example 1:
//
//
// Input: trips = [[2,1,5],[3,3,7]], capacity = 4
// Output: false
//
//
//
// Example 2:
//
//
// Input: trips = [[2,1,5],[3,3,7]], capacity = 5
// Output: true
//
//
//
// Example 3:
//
//
// Input: trips = [[2,1,5],[3,5,7]], capacity = 3
// Output: true
//
//
//
// Example 4:
//
//
// Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
// Output: true
//
//
//
//
//
//
//
//
//  
//
//
//
//
//  
// Constraints:
//
//
// 	trips.length <= 1000
// 	trips[i].length == 3
// 	1 <= trips[i][0] <= 100
// 	0 <= trips[i][1] < trips[i][2] <= 1000
// 	1 <= capacity <= 100000
//
//


class Solution {
    /**
     * 精妙，有现成的index
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int stops[] = new int[1001];
        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
        return capacity >= 0;
    }
        
    /**
     * 直接
     */
    public boolean carPoolingMy(int[][] trips, int capacity) {
        ArrayList<Integer[]> list = new ArrayList<>();
        for(int[] temp: trips){
            list.add(new Integer[]{temp[1], temp[0]});
            list.add(new Integer[]{temp[2], -temp[0]});
        }
        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(!o1[0].equals(o2[0])){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        int count = 0;
        for(Integer[] temp: list){
            count += temp[1];
            if(count > capacity){
                return false;
            }
        }
        return true;
    }
}
