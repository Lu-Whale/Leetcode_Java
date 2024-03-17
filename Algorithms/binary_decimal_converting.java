package Algorithms;

public class binary_decimal_converting {
    public static void main(String[] args) {

        // binary -> decimal
        String binaryString = "1010";
        // Using Built-in Method
        int decimal = Integer.parseInt(binaryString, 2);
        System.out.println(decimal);
        // Custom Logic
        int decimal2 = 0;
        for(int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(binaryString.length() - i - 1);
            if(bit == '1') {
                decimal2 += Math.pow(2, i);
            }
        }
        System.out.println(decimal2); // 输出10


        // Decimal to Binary Conversion
        int decimalNumber = 10;
        String binaryString2 = Integer.toBinaryString(decimalNumber);
        System.out.println(binaryString2); // Outputs 1010

        StringBuilder binaryString3 = new StringBuilder();
        while(decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binaryString3.insert(0, remainder); // Insert the remainder at the beginning of the string
            decimalNumber = decimalNumber / 2;
        }
        System.out.println(binaryString3.toString()); // Outputs 1010

    }
}
