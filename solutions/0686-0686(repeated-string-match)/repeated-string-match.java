// Given two strings a and b, return the minimum number of times you should repeat the string a so that string b is a substring of it. If it's impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
//
// Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and repeated 2 times is "abcabc".
//
//  
// Example 1:
//
//
// Input: a = "abcd", b = "cdabcdab"
// Output: 3
// Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
//
//
// Example 2:
//
//
// Input: a = "a", b = "aa"
// Output: 2
//
//
// Example 3:
//
//
// Input: a = "a", b = "a"
// Output: 1
//
//
// Example 4:
//
//
// Input: a = "abc", b = "wxyz"
// Output: -1
//
//
//  
// Constraints:
//
//
// 	1 <= a.length <= 104
// 	1 <= b.length <= 104
// 	a and b consist of lower-case English letters.
//
//


class Solution {
    /**
     * 直接
     */
    public int repeatedStringMatch(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int times = lenB/lenA;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++){
            sb.append(A);
        }
        if(sb.toString().contains(B)) return times;
        sb.append(A);
        if(sb.toString().contains(B)) return times+1;
        sb.append(A);
        if(sb.toString().contains(B)) return times+2;
        return -1;
    }
}
