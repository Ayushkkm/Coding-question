/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        ListNode temp = null;

        while(fast != null && fast.next != null){
            
            temp = slow;

            slow = slow.next;
            fast = fast.next.next;

        }
        
        if(slow == head){ // if 1 element -> head -> return null
            return null;
        }

        temp.next = slow.next; // delete -> middle -> node

        return head;
    }
}

// TC -> O(N)
// SC -> O(1)