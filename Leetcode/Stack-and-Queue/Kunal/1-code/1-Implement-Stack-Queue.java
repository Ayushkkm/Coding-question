import java.util.*;

public class Stack_and_Queue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(21);
        stack.push(30);
        stack.push(40);
        stack.push(52);

        System.out.println("Stack");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//      System.out.println(stack.pop()); // stack -> empty -> pop -> exception

        // TC -> Push -> Pop -> O(1)

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(3);
        queue.add(18);
        queue.add(20);
        queue.add(34);

        System.out.println("Queue");
        System.out.println("Peek" + queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("Deque");
        deque.add(3);
        deque.add(6);
        deque.addFirst(5);
        deque.addFirst(9);  // 9 -> 5 -> 3 -> 6
        System.out.println(deque.remove());
        System.out.println(deque.removeFirst());
        System.out.println( deque.removeLast());



    }
}
