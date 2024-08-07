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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null){
            return head;
        }

        int length = 0;
        ListNode temp = head;

        while(temp != null){
            temp = temp.next;
            length++;

        }

        int a = length - n; // a become i-> index
        
        if(a==0){
            return head.next;
        }

        temp = head;

        for(int i = 1 ; i < a ; i++){
            temp = temp.next;
        }
        
        if(temp.next != null)
        temp.next = temp.next.next;

        return head;

    }
}

// TC -> O(2N)
// SC -> O(1)