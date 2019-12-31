// A transaction is possibly invalid if:
//
//
// 	the amount exceeds $1000, or;
// 	if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
//
//
// Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
//
// Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
//
//  
// Example 1:
//
//
// Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
// Output: ["alice,20,800,mtv","alice,50,100,beijing"]
// Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
//
// Example 2:
//
//
// Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
// Output: ["alice,50,1200,mtv"]
//
//
// Example 3:
//
//
// Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
// Output: ["bob,50,1200,mtv"]
//
//
//  
// Constraints:
//
//
// 	transactions.length <= 1000
// 	Each transactions[i] takes the form "{name},{time},{amount},{city}"
// 	Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
// 	Each {time} consist of digits, and represent an integer between 0 and 1000.
// 	Each {amount} consist of digits, and represent an integer between 0 and 2000.
//
//


class Solution {
public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList();
        int n = transactions.length;
        if (n == 0) return ans;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] money = new int[n];
        String[] city = new String[n];
        boolean[] add = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] items = transactions[i].split(",");
            name[i] = items[0];
            time[i] = Integer.parseInt(items[1]);
            money[i] = Integer.parseInt(items[2]);
            city[i] = items[3];
        }
        
        for (int i = 0; i < n; i++) {
            if (money[i] > 1000)
                add[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) && Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
                    add[i] = true;
                    add[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (add[i])
                ans.add(transactions[i]);
        }
        return ans;
    }
}
