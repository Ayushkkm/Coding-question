
public class DynamicStack extends CustomStack{

    public DynamicStack() {
        super(); // it will call -> constructor -> CustomStack()
    }

    public DynamicStack(int size) {
        super(size); // it will call -> constructor -> CustomStack(int size)
    }

    @Override
    public boolean push(int item) {

        // when data -> is full
        if (this.isFull()) {

            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            // point data to -> temp
            data = temp;
        }

       // temp here -> out of scope -> data become double size

        // at this point we know that array is not full
        // insert item
        return super.push(item);
    }
}