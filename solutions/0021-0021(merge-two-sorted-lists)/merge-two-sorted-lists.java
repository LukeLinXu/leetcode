// Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head, run;
        if(l1.val >= l2.val){
            run = l2;
            l2 = l2.next;
        }else {
            run = l1;
            l1 = l1.next;
        }
        head = run;
        while (l1 != null && l2 != null){
            if(l1.val >= l2.val){
                run.next = l2;
                l2 = l2.next;
            }else {
                run.next = l1;
                l1 = l1.next;
            }
            run = run.next;
        }
        if(l1 == null){
            run.next = l2;
        }else {
            run.next = l1;
        }        
        return head;
    }
}
