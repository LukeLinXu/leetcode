// Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
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
// Example 1:
//
//
// Input: "ab-cd"
// Output: "dc-ba"
//
//
//
// Example 2:
//
//
// Input: "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"
//
//
//
// Example 3:
//
//
// Input: "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//  
//
//
// Note:
//
//
// 	S.length <= 100
// 	33 <= S[i].ASCIIcode <= 122 
// 	S doesn't contain \ or "
//
//
//
//
//


class Solution {
    /**
     * 直接
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c: S.toCharArray()){
            if(Character.isAlphabetic(c)){
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()){
            if(Character.isAlphabetic(c)){
                sb.append(stack.pop());
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
