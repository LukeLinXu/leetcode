// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
//
//
// Note:
// In the string, each word is separated by single space and there will not be any extra space in the string.
//


class Solution {
    /**
     * 直接
     */

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for(String temp: s1){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = temp.length() - 1; i >= 0; i--){
                stringBuilder.append(temp.charAt(i));
            }
            list.add(stringBuilder.toString());
        }
        return String.join(" ", list);
    }
}
