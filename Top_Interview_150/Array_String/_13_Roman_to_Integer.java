package Top_Interview_150.Array_String;

import java.util.HashMap;

public class _13_Roman_to_Integer {
    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int index = s.length() - 1;
        while (index >= 0) {
            if(index - 1 >= 0) {
                int cur = hashMap.get(s.charAt(index));
                int pre = hashMap.get(s.charAt(index - 1));
                if(cur > pre) {
                    res += (cur - pre);
                    index -= 2;
                }else {
                    res += cur;
                    index--;
                }
            }else {
                res += hashMap.get(s.charAt(index));
                index--;
            }
        }

        return res;
    }

}
