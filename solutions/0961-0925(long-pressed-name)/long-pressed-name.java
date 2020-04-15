// Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
//
// You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
//
//  
//
// Example 1:
//
//
// Input: name = "alex", typed = "aaleex"
// Output: true
// Explanation: 'a' and 'e' in 'alex' were long pressed.
//
//
//
// Example 2:
//
//
// Input: name = "saeed", typed = "ssaaedd"
// Output: false
// Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
//
//
//
// Example 3:
//
//
// Input: name = "leelee", typed = "lleeelee"
// Output: true
//
//
//
// Example 4:
//
//
// Input: name = "laiden", typed = "laiden"
// Output: true
// Explanation: It's not necessary to long press any character.
//
//
//  
//
//
//
//
// Note:
//
//
// 	name.length <= 1000
// 	typed.length <= 1000
// 	The characters of name and typed are lowercase letters.
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


class Solution {
    /**
     * 直接
     */
    public boolean isLongPressedName(String name, String typed) {
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < name.length()){
            char target = name.charAt(pos1);
            int count1 = 0;
            while (pos1 < name.length()){
                if(name.charAt(pos1) == target){
                    count1++;
                }else {
                    break;
                }
                pos1++;
            }

            int count2 = 0;
            while (pos2 < typed.length()){
                if(typed.charAt(pos2) == target){
                    count2++;
                }else {
                    break;
                }
                pos2++;
            }
            if(count2 < count1) return false; 
        }
        return pos2 >= typed.length();
    }
}
