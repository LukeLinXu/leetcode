// Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
//
//  
// Example 1:
//
//
// Input: date = "2019-01-09"
// Output: 9
// Explanation: Given date is the 9th day of the year in 2019.
//
//
// Example 2:
//
//
// Input: date = "2019-02-10"
// Output: 41
//
//
// Example 3:
//
//
// Input: date = "2003-03-01"
// Output: 60
//
//
// Example 4:
//
//
// Input: date = "2004-03-01"
// Output: 61
//
//
//  
// Constraints:
//
//
// 	date.length == 10
// 	date[4] == date[7] == '-', and all other date[i]'s are digits
// 	date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
//


class Solution {
    /**
     * 直接
     */
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int dateOfMonth = Integer.parseInt(split[2]);
        int is29 = year%100 == 0 ? (year%400 == 0?29:28):(year%4 == 0?29:28);
        int[] days = new int[]{31, is29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for(int i = 1; i < month; i++){
            count+=days[i - 1];
        }
        count+=dateOfMonth;
        return count;
    }
}
