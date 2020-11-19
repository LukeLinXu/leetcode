// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//
// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
//
//  
// Example 1:
// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// Output: [2,2,2,1,4,3,3,9,6,7,19]
//
//  
// Constraints:
//
//
// 	1 <= arr1.length, arr2.length <= 1000
// 	0 <= arr1[i], arr2[i] <= 1000
// 	All the elements of arr2 are distinct.
// 	Each arr2[i] is in arr1.
//
//


class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < arr2.length; i++){
//             map.put(arr2[i], -arr2.length + i);
//         }
//         Integer[] temp = new Integer[arr1.length];
//         for(int i = 0; i < arr1.length; i++){
//             temp[i] = arr1[i];
//         }
//         Arrays.sort(temp, new Comparator<Integer>() {
//             @Override
//             public int compare(Integer o1, Integer o2) {
//                 return map.getOrDefault(o1, o1) - map.getOrDefault(o2, o2);
//             }

//             @Override
//             public boolean equals(Object obj) {
//                 return false;
//             }
//         });
//         for(int i = 0; i < arr1.length; i++){
//             arr1[i] = temp[i];
//         }
//         return arr1;
//     }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int lastUpdatedIndex = -1;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = lastUpdatedIndex + 1; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    lastUpdatedIndex++;
                    int temp = arr1[j];
                    arr1[j] = arr1[lastUpdatedIndex];
                    arr1[lastUpdatedIndex] = temp;
                }
            }
        }
        int tempArr[] = Arrays.copyOfRange(arr1, lastUpdatedIndex + 1, arr1.length );
        Arrays.sort(tempArr);
        for (int i = lastUpdatedIndex + 1,j = 0; i < arr1.length && j<tempArr.length; i++,j++) {
            arr1[i] = tempArr[j];
        }

        return arr1;
    }
}
