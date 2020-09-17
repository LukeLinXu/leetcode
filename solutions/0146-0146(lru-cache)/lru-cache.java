// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
// Implement the LRUCache class:
//
//
// 	LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// 	int get(int key) Return the value of the key if the key exists, otherwise return -1.
// 	void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//
//
// Follow up:
// Could you do get and put in O(1) time complexity?
//
//  
// Example 1:
//
//
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]
//
// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
//
//
//  
// Constraints:
//
//
// 	1 <= capacity <= 3000
// 	0 <= key <= 3000
// 	0 <= value <= 104
// 	At most 3 * 104 calls will be made to get and put.
//
//


/**
* 使用双向链表，实现O(1), head 和 tail是整条链表的头尾界限，是为了更好的确定头尾的位置，然后操作。
*/

class LRUCache {
    
    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    final Map<Integer, Node> map;
    final int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
      int res = -1;
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        insertToHead(n);
        res = n.value;
      }
      return res;   
    }
    
    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        n.value = value;
        insertToHead(n);
      } else {
        
        if(map.size() == capacity){
           map.remove(tail.prev.key); 
           remove(tail.prev);
        } 
        
        Node n = new Node(key, value);
        insertToHead(n);
        map.put(key, n);
      }  
    }
    
    private void remove(Node n){
      n.prev.next = n.next;
      n.next.prev = n.prev;
    }
    
    private void insertToHead(Node n){
      Node headNext = head.next;
      head.next = n;
      headNext.prev = n;
      n.prev = head;
      n.next = headNext;
    }
    
    class Node{
      Node prev, next;
      int key, value;
      Node(int k, int v){
        key = k;
        value = v;
      }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
