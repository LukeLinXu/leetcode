// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
//
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
//
//


class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList();
        if(numRows == 0) return new ArrayList();
        if(numRows > 0){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            list.add(temp);
        }
        if(numRows > 1){
            for(int i = 1; i < numRows; i++){
                list.add(plusOne(list.get(list.size() - 1)));
            }
        }
        return list;
    }

    public List<Integer> plusOne(List<Integer> list1){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = list1.size() - 1; i > 0;i--){
            list.add(list1.get(i) + list1.get(i - 1));
        }
        list.add(1);
        return list;
    }
}
