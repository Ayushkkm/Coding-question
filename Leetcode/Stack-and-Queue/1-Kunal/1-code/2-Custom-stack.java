
public class CustomStack {

    public class StackException extends Exception {
        public StackException(String message) {
            super(message);
        }
    }  // For stack Exception

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    int ptr = -1; // point -> toward -> last -> element -> of stack

    public CustomStack(){
        this(DEFAULT_SIZE); // this -> here used -> to call -> constructor -> with default size -> other job is to give reference
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){

        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }

        ptr++; // point toward -> where is last -> added item
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException {

        if(isEmpty()){
            throw new StackException("Cannnot pop from empty array");
        }

        int val = data[ptr];
        ptr--;
        return val;
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannnot peek from empty array");
        }

        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length -1 ; // ptr++ -> make out of bound
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

}
