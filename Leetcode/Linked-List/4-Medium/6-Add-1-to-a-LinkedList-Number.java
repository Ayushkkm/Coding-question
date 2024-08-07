/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    
    public Node reverse(Node node){
        
        Node prev = null;
        Node curr = node;
        Node next = node.next;
        
        while(curr != null){
            
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if(next != null){
                next = next.next;
            }
        }
        
        return prev;
    }
    
    public Node addOne(Node head) {
        
        head = reverse(head);
        
        Node temp = head;
        
        while(temp != null){
            
            if(temp.next == null && temp.data == 9){ // null<-Node && Node == 9
                
                temp.data = 1;
                
                Node zero = new Node(0);
                
                zero.next = head;
                head = zero;
                
                temp = temp.next;
            }
            
            else if(temp.data == 9){
                
                temp.data = 0;
                
                temp = temp.next;
            }
            
            else{ // node.data != 9 -> simple -> add 1 -> break
                
                temp.data = temp.data +1;
                break;
            }
        }
        
        head = reverse(head);
        
        return head;
    }
}

// TC -> O(N)
// SC -> O(N)
