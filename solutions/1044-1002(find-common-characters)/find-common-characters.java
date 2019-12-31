// Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
// You may return the answer in any order.
//
//  
//
//
// Example 1:
//
//
// Input: ["bella","label","roller"]
// Output: ["e","l","l"]
//
//
//
// Example 2:
//
//
// Input: ["cool","lock","cook"]
// Output: ["c","o"]
//
//
//  
//
// Note:
//
//
// 	1 <= A.length <= 100
// 	1 <= A[i].length <= 100
// 	A[i][j] is a lowercase letter
//
//
//


class Solution {
       public List<String> commonChars(String[] A) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        if(A.length == 0) return result;
        for(char c : A[0].toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        if(A.length > 1){
            for(int i = 1; i < A.length; i++){
                for(char c : map.keySet()){
                    int origin = map.get(c);
                    int count = 0;
                    for(char temp : A[i].toCharArray()){
                        if(temp == c){
                            count++;
                        }
                    }
                    map.put(c, Math.min(origin, count));
                }
            }
        }
        for(char c : map.keySet()){
            for(int i = 0; i < map.get(c); i++){
                result.add(String.valueOf(c));
            }
        }
        return result;
    }
}
