
class stack{

    Node head;
    int size;

    public stack(){
        this.head = head;
        this.size = 0;
    }

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node node = new Node(data);
        
        node.next = head;
        head = node;
        size++;
    }

    public int pop(){
        if(head == null){
            return -1;
        }

        int data = head.data;
        head = head.next;
        size--;

        return data;

    }

    public int peek(){
        if(head == null){
            return -1;
        }

        int data = head.data;

        return data;
    }

    public boolean isEmpty(){

        return head == null;
    }

    public int size(){

        return size;
    }

}

// Every Operation -> O(1)