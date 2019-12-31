// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//
// Note that the row index starts from 0.
//
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
//
// Input: 3
// Output: [1,3,3,1]
//
//
// Follow up:
//
// Could you optimize your algorithm to use only O(k) extra space?
//


class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < rowIndex + 1; i++){
            plusOne(list);
        }
        return list;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> list){
        if(list.size() == 0){
            list.add(1);
            return list;
        }
        
        
        list.add(0);
        for(int i = list.size() - 1; i > 0;i--){
            
            list.set(i, list.get(i)+list.get(i - 1));
        }
        return list;
    }
}
