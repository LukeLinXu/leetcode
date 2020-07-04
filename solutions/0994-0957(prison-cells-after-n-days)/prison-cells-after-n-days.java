// There are 8 prison cells in a row, and each cell is either occupied or vacant.
//
// Each day, whether the cell is occupied or vacant changes according to the following rules:
//
//
// 	If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
// 	Otherwise, it becomes vacant.
//
//
// (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
//
// We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
//
// Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
//
//  
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: cells = [0,1,0,1,1,0,0,1], N = 7
// Output: [0,0,1,1,0,0,0,0]
// Explanation: 
// The following table summarizes the state of the prison on each day:
// Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
// Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
// Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
// Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
// Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
// Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
// Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
// Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//
//
//
//
// Example 2:
//
//
// Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
// Output: [0,0,1,1,1,1,1,0]
//
//
//  
//
// Note:
//
//
// 	cells.length == 8
// 	cells[i] is in {0, 1}
// 	1 <= N <= 10^9
//
//
//
//


class Solution {
    /**
     * 直接
     */
    public static int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> set = new HashMap<>(256);
        int days = 0;
        while (days < N){
            String temp = cellsToString(cells);
            if(set.containsKey(temp)){
                break;
            }else {
                set.put(temp, days);
                days++;
                cells = prisonAfterNDays(cells);
            }
        }
        if(days >= N) return cells;
        String temp = cellsToString(cells);
        int day = set.get(temp);
        int res = (N-day)%(days-day) + day;
        for(String s: set.keySet()){
            if(res == set.get(s)){
                for(int i = 0; i < s.toCharArray().length; i++){
                    cells[i] = s.charAt(i) - '0';
                }
                return cells;
            }
        }
        return null;
    }

    public static int[] prisonAfterNDays(int[] cells) {
        int[] res = cells.clone();
        res[0] = 0;
        res[res.length - 1] = 0;
        for(int i = 1; i < cells.length - 1; i++){
            res[i] = (cells[i-1] == cells[i+1])?1:0;
        }
        return res;
    }

    public static String cellsToString(int[] cells) {
        StringBuilder sb = new StringBuilder();
        for(int i : cells){
            sb.append(i);
        }
        return sb.toString();
    }
}
