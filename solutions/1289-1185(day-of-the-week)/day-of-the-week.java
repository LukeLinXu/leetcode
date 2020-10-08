// Given a date, return the corresponding day of the week for that date.
//
// The input is given as three integers representing the day, month and year respectively.
//
// Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
//
//  
// Example 1:
//
//
// Input: day = 31, month = 8, year = 2019
// Output: "Saturday"
//
//
// Example 2:
//
//
// Input: day = 18, month = 7, year = 1999
// Output: "Sunday"
//
//
// Example 3:
//
//
// Input: day = 15, month = 8, year = 1993
// Output: "Sunday"
//
//
//  
// Constraints:
//
//
// 	The given dates are valid dates between the years 1971 and 2100.
//
//


class Solution {
    /**
     * 直接
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int yearNow = 2020;
        int monthNow = 1;
        int dateNow = 15;
        int indexNow = 3;

        int diff = 0;
        for(int y = 1970; y < yearNow; y++){
            if(y % 4 == 0){
                diff += 366;
            }else {
                diff += 365;
            }
        }
        diff += (dateNow);
        indexNow = (diff-indexNow)%7;

        diff = 0;
        for(int y = 1970; y < year; y++){
            if(y % 4 == 0){
                diff += 366;
            }else {
                diff += 365;
            }
        }
        for(int m = 1; m < month; m++){
            if(m == 1 || m == 3 || m==5 || m==7||m==8||m==10||m==12){
                diff+=31;
            }else if(m == 4||m==6||m==9||m==11){
                diff+=30;
            }else if(year%4 == 0){
                diff+=29;
            }else {
                diff+=28;
            }
        }
        for(int d = 1; d < day; d++){
            diff++;
        }
        indexNow = (diff-indexNow+1)%7;
        return days[indexNow];
    }
}
