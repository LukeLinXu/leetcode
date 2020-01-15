// Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
//
// For each such occurrence, add "third" to the answer, and return the answer.
//
//  
//
// Example 1:
//
//
// Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
// Output: ["girl","student"]
//
//
//
// Example 2:
//
//
// Input: text = "we will we will rock you", first = "we", second = "will"
// Output: ["we","rock"]
//
//
//  
//
// Note:
//
//
// 	1 <= text.length <= 1000
// 	text consists of space separated words, where each word consists of lowercase English letters.
// 	1 <= first.length, second.length <= 10
// 	first and second consist of lowercase English letters.
//
//
//


class Solution {
    /**
     * 直接
     */
    public static String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length - 2; i++){
            if(s[i].equals(first) && s[i + 1].equals(second)){
                list.add(s[i+2]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
