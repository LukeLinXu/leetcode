// Write a class RecentCounter to count recent requests.
//
// It has only one method: ping(int t), where t represents some time in milliseconds.
//
// Return the number of pings that have been made from 3000 milliseconds ago until now.
//
// Any ping with time in [t - 3000, t] will count, including the current ping.
//
// It is guaranteed that every call to ping uses a strictly larger value of t than before.
//
//  
// Example 1:
//
//
// Input
// ["RecentCounter", "ping", "ping", "ping", "ping"]
// [[], [1], [100], [3001], [3002]]
// Output
// [null, 1, 2, 3, 3]
//
// Explanation
// RecentCounter recentCounter = new RecentCounter();
// recentCounter.ping(1);     // return 1
// recentCounter.ping(100);   // return 2
// recentCounter.ping(3001);  // return 3
// recentCounter.ping(3002);  // return 3
//
//
//  
// Constraints:
//
//
// 	1 <= t <= 104
// 	Each test case will call ping with strictly increasing values of t.
// 	At most 104 calls will be made to ping.
//
//


class RecentCounter {

    public RecentCounter() {
        
    }
    
    /**
     * 直接
     */
    Queue<Integer> queue = new LinkedList<Integer>();
    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && t - queue.peek() > 3000){
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
