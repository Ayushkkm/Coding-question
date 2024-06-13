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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }

        head = prev;
        return head;
    }
}

// Recursion code 

// class Solution {

//     private ListNode reverseRec(ListNode node) {
//         // Base case: if node is null or node is the last node
//         if (node == null || node.next == null) {
//             return node; // Return the last node as the new head
//         }

//         // Recur for the next node and get the new head
//         ListNode newHead = reverseRec(node.next);

//         // Reverse the link
//         node.next.next = node;
//         node.next = null; // Set the next of the current node to null

//         // Return the new head
//         return newHead;
//     }

//     public ListNode reverseList(ListNode head) {
//         return reverseRec(shead);
//     }
// }uu