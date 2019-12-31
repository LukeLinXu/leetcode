// In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.
//
// You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
//
// Example 1:
//
//
// Input: [1,4], 2
// Output: 4
// Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately. 
// This poisoned status will last 2 seconds until the end of time point 2. 
// And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds. 
// So you finally need to output 4.
//
//
//  
//
// Example 2:
//
//
// Input: [1,2], 2
// Output: 3
// Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned. 
// This poisoned status will last 2 seconds until the end of time point 2. 
// However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status. 
// Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3. 
// So you finally need to output 3.
//
//
//  
//
// Note:
//
//
// 	You may assume the length of given time series array won't exceed 10000.
// 	You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.
//
//
//  
//


public class Solution {
public static int findPoisonedDuration(int[] timeSeries, int duration) {

        for(int i = 0; i < timeSeries.length - 1; i++){
            if(timeSeries[i + 1] - timeSeries[i] <= 5){
                System.out.println(timeSeries[i]);
            }
        }

        if(duration == 0) return 0;
        int size = timeSeries.length;
        if(size == 0) return 0;
        int count = 0;
        int position = 0;
        while(position < timeSeries.length){
            int start = position;
            KeyValue end = findEnd(timeSeries, start, duration);
            count += end.getKey();
            position = end.getValue();
        }
        return count;
    }

    public static KeyValue findEnd(int[] timeSeries, int start, int duration){
        int length = timeSeries.length;
        int lastOne = timeSeries[length - 1];
        int left = start;
        int target = timeSeries[left] + duration;
        while (true){
            if(target > lastOne || left >= length - 1){
                return new KeyValue(lastOne + duration - timeSeries[start], length);
            }else if(target < timeSeries[left + 1]){
                return new KeyValue(target - timeSeries[start], left+1);
            }else {
                left = findLeft(timeSeries, left, target);
                target = timeSeries[left] + duration;
            }
        }
    }

    public static int findLeft(int[] timeSeries, int start, int target){
        int left = start + 1;
        int right = timeSeries.length - 1;
        int middle = left;
        while(left < right && right - left != 1){
            middle = (left + right)/2;
            if(target >= timeSeries[middle]){
                left = middle;
            }else{
                right = middle;
            }
        }
        return left;
    }

    public static class KeyValue{
        int key;
        int value;

        public KeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
