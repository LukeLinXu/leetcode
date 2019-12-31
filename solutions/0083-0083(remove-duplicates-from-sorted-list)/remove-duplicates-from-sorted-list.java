// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// Example 1:
//
//
// Input: 1->1->2
// Output: 1->2
//
//
// Example 2:
//
//
// Input: 1->1->2->3->3
// Output: 1->2->3
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        int current = head.val;
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null){
            if(current != fast.val){
                current = fast.val;
                slow = slow.next;
                fast = fast.next;
            }else {
                if(fast.next != null){
                    fast.val = fast.next.val;
                    fast.next = fast.next.next;
                }else {
                    fast = null;
                    slow.next = null;
                }
            }
        }
        return head;
    }
}
