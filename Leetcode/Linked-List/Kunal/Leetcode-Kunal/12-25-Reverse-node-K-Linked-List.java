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
    public ListNode reverseKGroup(ListNode head, int k) {
          if(k<=1 || head == null ){
              return head;
          }

        ListNode current = head;
        ListNode prev = null;

        while(true){

            ListNode last = prev;
            ListNode newEnd = current;

            // check k node is avaliable or not

            ListNode count = current;

            for(int i = 0 ; count !=null && i< k-1 ; i++){
                count = count.next;
            }

            if(count==null){
                break;
            }

            // reverse

            ListNode next = current.next;

            for(int i =0; i< k ;i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next!=null) next = next.next;
            }

            if(last!=null){
                last.next = prev;
            } else{
                head = prev;
            }

            newEnd.next = current;

           if(current == null){
               break;
           }

           prev = newEnd;
        }

        return head;

    }

}