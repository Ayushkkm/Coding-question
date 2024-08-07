/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        
        Node zero = new Node(0);
        Node one = new Node(0);
        Node two = new Node(0);
        
        Node z = zero;
        Node o = one;
        Node t = two;
        
        while(head != null){
            
            if(head.data == 0){
                
                z.next = head;
                z = z.next;
            }
            
            else if(head.data == 1){
                
                o.next = head;
                o = o.next;
            }
            
            else{
                t.next = head;
                t = t.next;
            }
            
            head = head.next;
        }
        
        // zero = zero.next;
        // one = one.next;
        // two = two.next;
                               // this order -> loose node
        // z.next = one;
        // o.next = two;
        // t.next = null;
        
        // return zero;
        
        t.next = null;
        o.next = two.next;
        z.next = one.next;
        
        return zero.next;
    }
}

// TC -> O(N)
// SC -> O(3N)
