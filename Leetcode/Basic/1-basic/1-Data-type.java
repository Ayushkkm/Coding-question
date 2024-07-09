class Solution {
    static int dataTypeSize(String str) {
        // GFG
       switch (str) {
            case "Character":
                return Character.SIZE / 8; // Character.SIZE is in bits, divide by 8 to get bytes
            case "Integer":
                return Integer.SIZE / 8;
            case "Long":
                return Long.SIZE / 8;
            case "Float":
                return Float.SIZE / 8;
            case "Double":
                return Double.SIZE / 8;
            default:
                return -1; // Handle unknown data types
    }
 }
} 