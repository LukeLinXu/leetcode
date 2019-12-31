// Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//  
//
// Example:
//
//
// Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }else if(head.next == null){
            return head;
        }

        ListNode a = swapFirst2(head);
        ListNode b = a.next;
        while (b.next != null && b.next.next != null){
            b.next = swapFirst2(b.next);
            b = b.next.next;
        }
        return a;
    }

    public ListNode swapFirst2(ListNode head){
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = b.next;
        b.next = a;
        a.next = c;
        head = b;
        return head;
    }
}
