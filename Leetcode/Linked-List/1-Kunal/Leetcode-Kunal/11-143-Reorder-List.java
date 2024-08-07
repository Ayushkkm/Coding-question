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

    public ListNode reverseList(ListNode head){

        if(head==null) return null;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present!=null){
            present.next = prev;
            prev = present ;
            present = next;
            if(next!=null){
                next = next.next;
            }
        }

        return prev;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public void reorderList(ListNode head) {
      if(head == null || head.next == null){
          return ;
      }

      ListNode mid = middleNode(head);

      ListNode hs = reverseList(mid);
      ListNode hf = head;

      // rearrange

        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf =temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp ;

        }

        if(hf != null){ // if last is hs -> hs != null -> its last -> is at null already
            hf.next = null;
        }

    }
}