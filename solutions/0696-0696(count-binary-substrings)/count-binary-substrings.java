// Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively. 
//
// Substrings that occur multiple times are counted the number of times they occur.
//
// Example 1:
//
// Input: "00110011"
// Output: 6
// Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of times they occur.
// Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//
//
//
// Example 2:
//
// Input: "10101"
// Output: 4
// Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
//
//
//
// Note:
// s.length will be between 1 and 50,000.
// s will only consist of "0" or "1" characters.
//


class Solution {
    
    /**
     *  精辟，solution太好了
     */    
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
    
    
    /**
     *   尽量不用ArrayList;  从不同处进行扩散，不如用Math.min进行比较
     */
    public int countBinarySubstringsTT(String s) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                list.add(i);
                sum++;
            }
        }

        for (int left : list) {
            int right = left + 1;
            while (left - 1 >= 0 && right + 1 <= s.length() - 1) {
                if (s.charAt(left - 1) == s.charAt(left) && s.charAt(right) == s.charAt(right + 1)) {
                    sum++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
