import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BinaryTreePostorder {
    
    public static List<Integer> postOrder(Node root) {
        
        List<Integer> postorder = new ArrayList<>();

        if (root == null) {
            return postorder;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.empty()) {
        
            root = st1.pop();

            st2.push(root);

            if (root.left != null) {
                st1.push(root.left);
            }

            if (root.right != null) {
                st1.push(root.right);
            }
        }

        while (!st2.empty()) {
            postorder.add(st2.pop().data);
        }

        return postorder;
    }