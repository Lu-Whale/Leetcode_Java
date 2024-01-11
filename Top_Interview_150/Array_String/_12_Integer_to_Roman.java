package Top_Interview_150.Array_String;

import java.util.HashMap;
import java.util.Stack;

public class _12_Integer_to_Roman {
    public static String intToRoman(int num) {
        String s = Integer.toString(num);

        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();

        Stack<String> reverse = new Stack<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "I");
        hashMap.put(4, "IV");
        hashMap.put(5, "V");
        hashMap.put(9, "IX");
        hashMap.put(10, "X");
        hashMap.put(40, "XL");
        hashMap.put(50, "L");
        hashMap.put(90, "XC");
        hashMap.put(100, "C");
        hashMap.put(400, "CD");
        hashMap.put(500, "D");
        hashMap.put(900, "CM");
        hashMap.put(1000, "M");

        int base = 1;
        for(int i = n - 1; i >= 0; i--) {
            int tmp = s.charAt(i) - '0';

            if(hashMap.containsKey(tmp *  base)) {
                reverse.push(hashMap.get(tmp * base));
            }else {
                StringBuilder tmpSb = new StringBuilder();
                if(tmp <= 3) {
                    for(int j = 0; j < tmp; j++) {
                        tmpSb.append(hashMap.get(base));
                    }
                }else if(tmp >= 6) {
                    tmpSb.append(hashMap.get(5 * base));
                    for(int j = 0; j < tmp - 5; j++) {
                        tmpSb.append(hashMap.get(base));
                    }
                }
                reverse.push(tmpSb.toString());
            }
            base *= 10;
        }

        while (!reverse.isEmpty()) {
            stringBuilder.append(reverse.pop());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println(intToRoman(num));
    }
}
