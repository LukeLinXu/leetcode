// You have an array of logs. Each log is a space-delimited string of words.
//
// For each log, the first word in each log is an alphanumeric identifier. Then, either:
//
//
// 	Each word after the identifier will consist only of lowercase letters, or;
// 	Each word after the identifier will consist only of digits.
//
//
// We will call these two varieties of logs letter-logs and digit-logs. It is guaranteed that each log has at least one word after its identifier.
//
// Reorder the logs so that all of the letter-logs come before any digit-log. The letter-logs are ordered lexicographically, ignoring identifiers, with the identifier used in case of ties. The digit-logs should be put in their original order.
//
// Return the final order of the logs.
//
//  
// Example 1:
//
//
// Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
// Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
//
//
// Example 2:
//
//
// Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
// Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
//
//
//  
// Constraints:
//
//
// 	1 <= logs.length <= 100
// 	3 <= logs[i].length <= 100
// 	All the tokens of logs[i] are separated by single spaces.
// 	logs[i] is guaranteed to have an identifier and a word after the identifier.
//
//


class Solution {

    /**
     * 注意split里面limit的用法，他会把后面所有的string集合成1个
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);
                if(isInt(s1[1]) && isInt(s2[1])){
                    return 0;
                }else if(!isInt(s1[1]) && isInt(s2[1])){
                    return -1;
                }else if(isInt(s1[1]) && !isInt(s2[1])){
                    return 1;
                }else{
                    return compareTo(s1, s2);
                }
                
            }
        });
        return logs;
    }

    public boolean isInt(String s){
        char c = s.charAt(0);
        return c>= '0' && c <='9';
    }

    public int compareTo(String[] origin, String[] anotherString) {
        int i = origin[1].compareTo(anotherString[1]);
        if(i == 0){
            return origin[0].compareTo(anotherString[0]);
        }else {
            return i;
        }
    }
}
