// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//
// P   A   H   N
// A P L S I I G
// Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a number of rows:
//
//
// string convert(string s, int numRows);
//
// Example 1:
//
//
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
//
//
// Example 2:
//
//
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
//
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
//


public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1 ) return s;
        char[] chars = s.toCharArray();
        int size = chars.length;
        StringBuffer sb = new StringBuffer(size);

        for(int i = 0; i < numRows; i++){
            if(i == 0){
                int current = 0;
                while(current < size){
                    sb.append(chars[current]);
                    current += 2 * (numRows - 1);
                }
            }else if(i == numRows - 1){
                int current = numRows - 1;
                while(current < size){
                    sb.append(chars[current]);
                    current += 2 * (numRows - 1);
                }
            }else {
                int current = i;
                while(current < size){
                    sb.append(chars[current]);
                    current += 2 * (numRows - 1) - 2 * i;
                    if(current < size){
                        sb.append(chars[current]);
                        current += 2 * i;
                    }else {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
