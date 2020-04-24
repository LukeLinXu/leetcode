// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
// The cache is initialized with a positive capacity.
//
// Follow up:
// Could you do both operations in O(1) time complexity?
//
// Example:
//
//
// LRUCache cache = new LRUCache( 2 /* capacity */ );
//
// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4
//
//
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
