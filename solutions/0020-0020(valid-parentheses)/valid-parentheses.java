// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
//
// 	Open brackets must be closed by the same type of brackets.
// 	Open brackets must be closed in the correct order.
//
//
// Note that an empty string is also considered valid.
//
// Example 1:
//
//
// Input: "()"
// Output: true
//
//
// Example 2:
//
//
// Input: "()[]{}"
// Output: true
//
//
// Example 3:
//
//
// Input: "(]"
// Output: false
//
//
// Example 4:
//
//
// Input: "([)]"
// Output: false
//
//
// Example 5:
//
//
// Input: "{[]}"
// Output: true
//
//


public class Solution {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for(int c : chars){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.size() == 0){
                    return false;
                }else if(c == ')' && (int)stack.peek() == '('){
                    stack.pop();
                }else if(c == ']' && (int)stack.peek() == '['){
                    stack.pop();
                }else if(c == '}' && (int)stack.peek() == '{'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(stack.size() == 0) return true;
        return false;
    }
}
