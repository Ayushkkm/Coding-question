
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0 ; i < lists.length ; i++){

            ListNode head = lists[i];

            while(head != null){
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while(!minHeap.isEmpty()){
            ListNode temp = new ListNode(minHeap.remove()); // we are making -> new temp -> take time -> in optimal -> remove it

            node.next = temp;
            node = node.next;
        }

        node.next = null;

        return head.next;
           
    }
}

// TC -> O(N*logN) -> n -> total nodes
// SC -> O(N) -> Priority Queue


// Optimal 


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
    
    class pair implements Comparable<pair> {
        ListNode node;

        public pair(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(pair other) {
            return Integer.compare(this.node.val, other.node.val);

        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<pair> minHeap = new PriorityQueue<>();

        
        for (ListNode list : lists) { // Add all -> nodes to -> the priority queue

            if(list != null) {
                minHeap.add(new pair(list)); // just add 1 -> element -> head of -> all list -> because they are -> least of list
                
            }
        }

        ListNode head = new ListNode(0); // ans list
        ListNode node = head;

        
        while (!minHeap.isEmpty()) { // merging the -> list

            pair p = minHeap.remove();
           
            ListNode a = p.node;

            node.next = a;
            node = node.next;

            if(a.next != null){  // add next -> node of lists -> because they are -> in sorted 
                minHeap.add(new pair(a.next));
            }
        }
        
        node.next = null; // make last node -> to null

        return head.next;
    }
}

// TC -> O(K*logK) -> k is number of list
// SC -> O(K) -> priority queue

