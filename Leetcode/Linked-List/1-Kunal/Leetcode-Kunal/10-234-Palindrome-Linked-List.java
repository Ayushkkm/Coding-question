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
    public boolean isPalindrome(ListNode head) {

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        while(head!=null && headSecond!=null){
            if(head.val != headSecond.val){
                break;
            }

            head = head.next;
            headSecond = headSecond.next;
        }
        
        reverseList(rereverseHead);
        
        return head == null || headSecond == null;
    }

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
            fast = fast.next.next;i
        }

        return slow;

    }
}