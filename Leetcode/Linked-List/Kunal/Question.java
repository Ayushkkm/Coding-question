
public class Question {
    private Node head;
    private Node tail;
    private int size;

    public Question() {
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
        for(int i =1; i<index; i++){
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

        for(int i =0; i<index ; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
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

    // Question 1 - Insert using Recursion

    public void insertRec(int val , int index){

        head = insertRec(val,index,head);
    }

    private Node insertRec(int val , int index , Node node){
        if(index==0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next = insertRec(val,--index,node.next);
        return node;
    }

    // Question 2 - Remove Duplicates

    public void duplicates(){
        Node node = head;

        while(node.next!=null){  // It is for -> we reach last node

            if(node.value == node.next.value){

                node.next = node.next.next;  // We don't move node , we move next of node
                size--;
            }
            else{
                node = node.next;
            }

        }
        // we are at last -> node
        tail = node;
        tail.next = null;

    }

    // Question 3 - Merge two sorted list

    public static Question merge(Question first , Question second){
        Node f = first.head;
        Node s = second.head;

        Question ans = new Question();

        while(f!=null && s!=null){
            if(f.value<s.value){
                ans.insertLast(f.value);
                f=f.next;
            }
            else{
                ans.insertLast(s.value);
                s=s.next;
            }
        }
        while(f!=null){
            ans.insertLast(f.value);
            f=f.next;
        }

        while(s!=null){
            ans.insertLast(s.value);
            s=s.next;
        }
        return ans;
    }

    // Question 4 - Linked List Cycle

    public static boolean hasCycle(Node head) {
        if(head==null) return false;

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;

            if(slow==fast) return true;

        }

        return false;

    }
// Head and tail is private so cannot used in other file
    public static void MakeCycle(Question q){
        q.tail.next = q.head;
    }

    public static Node hasHead(Question q){

        return q.head;
    }

    // Question 5 - length of cycle
    public static int lengthCycle(Node head) {

        Node slow = head;
        Node fast = head;

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

    // Question 6 - find starting node of cycle

    public static Node detectCycle(Node head) {

        int length = 0;

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;

            if(slow==fast){
                length = lengthCycle(slow);
                break;
            }
        }

        if(length==0){
            return null;
        }

        // find the start node

        Node f = head;
        Node s = head;

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

    // Question 7 - Happy Number

    // Without static it can run in main ,
    // but we have to make object of class
    // q.isHappy not Question.isHappy

    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow!=fast);

        if(slow==1) return true;
        return false;
    }

    private static int findSquare(int number){
        int ans = 0 ;

        while(number>0){
            int rem = number % 10;
            ans += rem*rem;

            number = number/10;
        }
        return ans;
    }

    // Question 8 - Middle of linked list

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    // Question 9 - Sort Linked List by merge sort

    public Node merge(Node list1 , Node list2){
        Node dummyhead = new Node(0);

        Node tail = dummyhead;

        while(list1!=null && list2!=null){
            if(list1.value<list2.value){
                tail.next=list1;
                list1 = list1.next;
                tail = tail.next;
            }
            else{
                tail.next=list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 !=null) ? list1:list2;

        return dummyhead.next;
    }

    public Node getmiddle(Node head) {

        if (head == null) return head;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node sortList(Node head) {
        if(head == null || head.next == null) return head;
        Node mid = getmiddle(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);

    }

    // Question 10 - Recursion reverse

    public void recusionRev(Node node){
        if(node==tail){
            head=tail;
            return;
        }

        recusionRev(node.next);
        tail.next=node;
        tail = node;
        tail.next = null;
    }


    // for debug purpose
    // if we call q.recusrionRev(Node node) ,
    // then recursion happen in following way take tail and head of q.


//    public static void recusionRev(Node node,Question q){
//
//        if(node==q.tail){
//            q.head = q.tail;
//            return;
//        }
//
//        recusionRev(node.next,q);
//        q.tail.next = node;
//        q.tail = node;
//        q.tail.next = null;
//
//        }


    //  Question 11 - Reverse LinkedList by iterative

    public void reverse(){
        if(size<2){
            return ;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null){
                next = next.next;
            }
        }
        head = prev;
    }

    // Leetcode

    public Node reverseList(Node head){

        if(head==null) return null;

        Node prev = null;
        Node present = head;
        Node next = present.next;

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

    // Question 12 - Reverse LinkedList 2

    public Node reverseBetween(Node head, int left, int right) {
          if(left==right){
              return head;
          }

          // skip  the first left-1 node

          Node current = head;
          Node prev = null;

          for(int i = 0 ; current !=null && i< left-1;i++){
              prev = current;
              current = current.next;
          }

          Node last = prev;
          Node newEnd = current;

          // reverse between left and right

          Node next = current.next;

          for(int i =0; i< right - left +1 ;i++){
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

          return head;
    }

    // Question 13 - Palindrome LinkedList

    public boolean isPalindrome(Node head) {

        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node rereverseHead = headSecond;

        while(head!=null && headSecond!=null){
            if(head.value != headSecond.value){
                break;
            }

            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(rereverseHead);

        return head == null || headSecond == null;

    }

    // Question 14 - Reorder LinkedList

    public void reorderList(Node head) {
      if(head == null || head.next == null){
          return ;
      }

      Node mid = middleNode(head);

      Node hs = reverseList(mid);
      Node hf = head;

      // rearrange

        while(hf != null && hs != null){
            Node temp = hf.next;
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

    // Question 15 - Reverse k-nodes in Linked List

    public Node reverseKGroup(Node head, int k) {
          if(k<=1 || head == null ){
              return head;
          }

        Node current = head;
        Node prev = null;

        while(true){

            Node last = prev;
            Node newEnd = current;

            // check k node is avaliable or not

            Node count = current;

            for(int i = 0 ; count !=null && i< k-1 ; i++){
                count = count.next;
            }

            if(count==null){
                break;
            }

            // reverse

            Node next = current.next;

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

    // Question 16 - Reverse Alternate k-nodes in linked list

    public Node reverseAlternateKGroup(Node head, int k) {
        if(k<=1 || head == null ){
            return head;
        }

        Node current = head;
        Node prev = null;

        while(current!=null){

            Node last = prev;
            Node newEnd = current;


            // reverse

            Node next = current.next;

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

            // Skip the k nodes

            for(int i = 0; current != null && i<k ;i++){
                prev = current;
                current = current.next;
            }
        }

        return head;

    }

    // Question 17 - Rotate Linked List

    public Node rotateRight(Node head, int k) {
        if(k==0 || head ==null || head.next ==null){
            return head;
        }

        // find length and last node

        Node last = head;
        int length = 1;

        while(last.next!=null){
            last = last.next;
            length++;
        }

        last.next = head;

        int rotations = k % length;
        int skip = length - rotations;

        Node newLast = head;
        for(int i = 0 ; i< skip-1;i++){
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;


    }


}
