// Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
//
//
// Note:
//
// The length of num is less than 10002 and will be ≥ k.
// The given num does not contain any leading zero.
//
//
//
//
// Example 1:
//
// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//
//
//
// Example 2:
//
// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//
//
//
// Example 3:
//
// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.
//
//


class Solution {
    /**
     * 挺好的解法，谈不上精妙
     */
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()){
            while (k>0 && !stack.isEmpty() && stack.peek() > c){
                //开始处理k,慢慢剔除
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // 注意要处理k没有用完的情形
        while (k > 0){
            stack.pop();
            k--;
        }
        
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //要大于1的原因是，如果剩下最后一个零，得留住啊
        while (sb.length() > 1 && sb.charAt(sb.length()-1) == '0'){
            //这个方法太贱了
            sb.deleteCharAt(sb.length()-1);
        }
        //这个方法太贱了
        sb.reverse();
        return sb.toString();
    }
}
