/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

   public static int lengthCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;

            // cycle is found
            if(slow==fast) {

                int length = 0;

                do{
                    slow = slow.next;
                    length++;
                }
                while(slow!=fast);

                return length;
            }
        }

        return 0;
    }


    public static ListNode detectCycle(ListNode head) {

       int length = lengthCycle(head);

        if(length==0){
            return null;
        }
   
        // find the start node

       ListNode f = head;
       ListNode s = head;

        while(length>0){
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start

        while(f!=s){
            f=f.next;
            s=s.next;
        }

        return s;

    }

    
}