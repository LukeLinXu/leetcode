// Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes. Only nodes itself may be changed.
//
//  
// Example 1:
//
//
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
//
//
// Example 2:
//
//
// Input: head = []
// Output: []
//
//
// Example 3:
//
//
// Input: head = [1]
// Output: [1]
//
//
//  
// Constraints:
//
//
// 	The number of nodes in the list is in the range [0, 100].
// 	0 <= Node.val <= 100
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
