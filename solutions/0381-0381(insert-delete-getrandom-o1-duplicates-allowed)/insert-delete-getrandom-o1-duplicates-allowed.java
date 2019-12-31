// Design a data structure that supports all following operations in average O(1) time.
// Note: Duplicate elements are allowed.
//
//
// insert(val): Inserts an item val to the collection.
// remove(val): Removes an item val from the collection if present.
// getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
//
//
//
// Example:
//
// // Init an empty collection.
// RandomizedCollection collection = new RandomizedCollection();
//
// // Inserts 1 to the collection. Returns true as the collection did not contain 1.
// collection.insert(1);
//
// // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
// collection.insert(1);
//
// // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
// collection.insert(2);
//
// // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
// collection.getRandom();
//
// // Removes 1 from the collection, returns true. Collection now contains [1,2].
// collection.remove(1);
//
// // getRandom should return 1 and 2 both equally likely.
// collection.getRandom();
//
//


public class RandomizedCollection {

    private HashMap<Integer, Integer> map;
    private int sum;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Integer>();
        sum = 0;
    }

    /** Inserts a value to the map. Returns true if the map did not already contain the specified element. */
    public boolean insert(int val) {
        sum++;
        if(map.containsKey(val)){
            map.put(val, map.get(val)+1);
            return false;
        }else {
            map.put(val, 1);
            return true;
        }
    }

    /** Removes a value from the map. Returns true if the map contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            sum--;
            int value = map.get(val);
            if(value == 1){
                map.remove(val);
            }else {
                map.put(val, value-1);
            }
            
            return true;
        }else {
            return false;
        }
    }

    /** Get a random element from the map. */
    public int getRandom() {
        int size = sum;
        int item = new Random().nextInt(size)+1; // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(int obj : map.keySet())
        {
            int count = map.get(obj);
            if(i + count >= item && item > i){
                return obj;
            }else {
                i += count;
            }
        }
        return 0;
    }
}
