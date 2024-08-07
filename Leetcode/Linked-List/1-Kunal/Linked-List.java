
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
       Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val , int index){
        if(index==0){
            insertFirst(val);
            return ;
        }

        if(index==size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i =1; i<index; i++){ // 1 -> index -1 -> one before -> node index
            temp = temp.next;
        }

        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;

    }

    public int deleteFirst(){
        if(head==null){
            return -1;
        }

        int value = head.value;
        head =head.next;

        if(head==null){
            tail = null;
        }
        size--;
        return value;
    }

    public Node get(int index){
        Node node = head;

        for(int i =0; i<index ; i++){ // 0 -> index -1 -> to reach -> index node
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2); // n-2 -> give -> 0 -> n-3 -> loop run
        int value = tail.value;
        tail = secondLast;
        secondLast.next = null;
        size--;
        return value;
    }
  public int size(){
        return size;
  }

  public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
  }

    public Node find(int value){
        Node node = head;

        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }



}
