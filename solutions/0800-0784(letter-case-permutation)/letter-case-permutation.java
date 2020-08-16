// Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
//
// Return a list of all possible strings we could create. You can return the output  in any order.
//
//  
// Example 1:
//
//
// Input: S = "a1b2"
// Output: ["a1b2","a1B2","A1b2","A1B2"]
//
//
// Example 2:
//
//
// Input: S = "3z4"
// Output: ["3z4","3Z4"]
//
//
// Example 3:
//
//
// Input: S = "12345"
// Output: ["12345"]
//
//
// Example 4:
//
//
// Input: S = "0"
// Output: ["0"]
//
//
//  
// Constraints:
//
//
// 	S will be a string with length between 1 and 12.
// 	S will consist only of letters or digits.
//
//


class Solution {
    /**
     * 直接
     */
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        for(char c: S.toCharArray()){
            letterCasePermutation(list, c);
        }
        return list;
    }
    
    public void letterCasePermutation(List<String> list, char c){
        if(Character.isAlphabetic(c)){
            char cp = getChar(c);
            if(list.size() == 0){
                list.add(String.valueOf(c));
                list.add(String.valueOf(cp));
            }else {
                list.addAll(list);
                for(int i = 0; i < list.size(); i++){
                    if(i < list.size()/2){
                        list.set(i, list.get(i)+cp);
                    }else {
                        list.set(i, list.get(i)+c);
                    }
                }
            }
        }else {
            if(list.size() == 0){
                list.add(String.valueOf(c));
            }else{
                for(int i = 0; i < list.size(); i++){
                list.set(i, list.get(i)+c);
            }
            }
            
        }
    }

    public char getChar(char c){
        if(c >='a' && c <='z'){
            return (char) (c-'a'+'A');
        }else {
            return (char) (c-'A'+'a');
        }
    }
}
