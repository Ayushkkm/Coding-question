/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int length(ListNode head){
        int length = 0;

        while(head != null){
            head = head.next;
            length++;
        }

        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = length(headA);
        int lenB = length(headB);

        while(lenA > lenB){ // if lenA -> is greater
          
           headA = headA.next;
           lenA--;
        }

        while(lenB > lenA){ // if lenB -> is greater

            headB = headB.next;
            lenB--;
        }

        while(headA != headB){ // both start -> same -> length -> if -> no -> intersection -> both reach -> null -> simultaneously
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}

// TC -> O(N+M)
// SC -> O(1)