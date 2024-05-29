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

    public int binaryStringToInt(String binaryString) {
        int result = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            result = result * 2 + (c - '0');  // 将前一个结果左移一位（乘以2），加上当前位的值
        }
        return result;
    }

    public String intToBinaryString(int number) {
        if (number == 0) return "0";
        StringBuilder binaryString = new StringBuilder();
        while (number > 0) {
            int remainder = number % 2;
            binaryString.append(remainder);  // 添加二进制位
            number /= 2;
        }
        return binaryString.reverse().toString();  // 反转字符串以获取正确的二进制顺序
    }


}
