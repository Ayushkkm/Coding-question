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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;

        while(odd.next !=null && odd.next.next !=null && temp.next != null && temp.next.next!=null){
           
           odd.next = odd.next.next;
           odd = odd.next;

           temp.next = temp.next.next;
           temp = temp.next;
        }

        while(odd.next !=null && odd.next.next !=null){ // if remove -> make connection -> of odd
           odd.next = odd.next.next;
           odd = odd.next;
        }

        while(temp.next != null && temp.next.next!=null){ // if remove -> make connection -> of even
           temp.next = temp.next.next;
           temp = temp.next;
        }

        odd.next = even;
        temp.next = null;

        return head;

    }
}

// TC -> O(N)
// SC -> O(1)
