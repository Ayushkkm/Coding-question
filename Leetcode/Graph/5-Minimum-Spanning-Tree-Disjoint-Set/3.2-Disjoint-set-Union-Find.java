
class GfG {

    // GFG

    // Function to find the ultimate parent of X
    int find(int A[], int X) {
        if (A[X] == X) {
            return X;
        }
        // Path compression
        A[X] = find(A, A[X]);
        return A[X];
    }

    // Function to perform union of X and Z
    void unionSet(int A[], int X, int Z) {
        int parentX = find(A, X);
        int parentZ = find(A, Z);

        if (parentX != parentZ) {
            A[parentX] = parentZ;  // Making Z's parent the parent of X
        }
    }
}