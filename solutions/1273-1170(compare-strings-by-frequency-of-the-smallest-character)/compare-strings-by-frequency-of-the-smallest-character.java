// Let's define a function f(s) over a non-empty string s, which calculates the frequency of the lexicographically smallest character in s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is "c" and its frequency is 2.
//
// Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
//
//  
// Example 1:
//
//
// Input: queries = ["cbd"], words = ["zaaaz"]
// Output: [1]
// Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
//
//
// Example 2:
//
//
// Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
// Output: [1,2]
// Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
//
//
//  
// Constraints:
//
//
// 	1 <= queries.length <= 2000
// 	1 <= words.length <= 2000
// 	1 <= queries[i].length, words[i].length <= 10
// 	queries[i][j], words[i][j] are English lowercase letters.
//
//


class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] wordsCount = new int[words.length];
        for(int i = 0; i <words.length;i++){
            wordsCount[i] = getNumber(words[i]);
        }
        int[] result = new int[queries.length];
        for(int i = 0; i<result.length; i++){
            int temp = getNumber(queries[i]);
            int count = 0;
            for(int j : wordsCount){
                if(j>temp){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    private int getNumber(String s){
        char[] chars = s.toCharArray();
        if(chars.length <=1) return chars.length;
        int count = 0;
        char min = chars[0];
        for(char i : chars){
            if(i == min){
                count++;
            }else {
                if(i < min){
                    count = 1;
                    min = i;
                }
            }
        }
        return count;
    }
}
