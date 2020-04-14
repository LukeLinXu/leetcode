// Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
//
// Note that after backspacing an empty text, the text will continue empty.
//
//
// Example 1:
//
//
// Input: S = "ab#c", T = "ad#c"
// Output: true
// Explanation: Both S and T become "ac".
//
//
//
// Example 2:
//
//
// Input: S = "ab##", T = "c#d#"
// Output: true
// Explanation: Both S and T become "".
//
//
//
// Example 3:
//
//
// Input: S = "a##c", T = "#a#c"
// Output: true
// Explanation: Both S and T become "c".
//
//
//
// Example 4:
//
//
// Input: S = "a#c", T = "b"
// Output: false
// Explanation: S becomes "c" while T becomes "b".
//
//
// Note:
//
//
// 	1 <= S.length <= 200
// 	1 <= T.length <= 200
// 	S and T only contain lowercase letters and '#' characters.
//
//
// Follow up:
//
//
// 	Can you solve it in O(N) time and O(1) space?
//
//
//
//
//
//


class Solution {
    /**
    * 好题
    **/
    public boolean backspaceCompare(String S, String T) {
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;
        int backspaceS = 0;
        int backspaceT = 0;
        while (indexS >= 0 || indexT>=0){
            while (indexS>=0){
                if(S.charAt(indexS) == '#'){
                    indexS--;
                    backspaceS++;
                }else if(backspaceS > 0){
                    backspaceS--;
                    indexS--;
                }else {
                    break;
                }
            }
            while (indexT>=0){
                if(T.charAt(indexT) == '#'){
                    indexT--;
                    backspaceT++;
                }else if(backspaceT > 0){
                    backspaceT--;
                    indexT--;
                }else {
                    break;
                }
            }
            if(indexS >= 0 && indexT>= 0 && S.charAt(indexS) != T.charAt(indexT)){
                return false;
            }
            if((indexS >= 0) != (indexT>= 0)){
                return false;
            }
            indexS--;
            indexT--;
        }
        return true;
//        return backspaceCompareHelper(S).equals(backspaceCompareHelper(T));
    }

    public String backspaceCompareHelper(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
