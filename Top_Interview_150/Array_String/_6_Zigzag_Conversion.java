package Top_Interview_150.Array_String;

import java.util.HashMap;

public class _6_Zigzag_Conversion {
    public static String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }

        HashMap<Integer, StringBuilder> hashMap = new HashMap<>();
        int pointer = 1;
        boolean down = true;
        for(int i = 0; i < s.length(); i++) {
            hashMap.put(pointer, hashMap.getOrDefault(pointer, new StringBuilder()).append(s.charAt(i)));
            if((pointer == 1 || pointer == numRows) && i != 0) {
                down = !down;
            }
            pointer = down ? pointer + 1 : pointer - 1;
        }
        System.out.println(hashMap.size());

        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= numRows; i++) {
            res.append(hashMap.getOrDefault(i, new StringBuilder()));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        int numRows = 2;

        System.out.println(convert(s, numRows));
    }
}
