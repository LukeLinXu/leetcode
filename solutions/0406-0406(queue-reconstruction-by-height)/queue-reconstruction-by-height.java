// Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
//
// Note:
// The number of people is less than 1,100.
//  
//
// Example
//
//
// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//
//
//  
//


class Solution {
    /**
     * 被hint骗了，倒过来想更快些
     */
    public int[][] reconstructQueue1(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
    }
    /**
     * 直接，这是我的版本，其实我的版本好像更快，可能是int list 消耗不大吧
     */
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });
        ArrayList<Integer> list = new ArrayList<>(len);
        for(int i = 0; i < len; i++){
            list.add(i);
        }
        int[][] res = new int[len][2];
        for(int[] temp: people){
            int k = list.get(temp[1]);
            res[k] = temp;
            list.remove(temp[1]);
        }
        return res;
    }
}
