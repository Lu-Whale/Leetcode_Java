package Daily_Question;

import javax.management.StringValueExp;
import java.util.HashMap;

public class _791_Custom_Sort_String {
    public String customSortString(String order, String s) {
        // initiate the hashmap
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : order.toCharArray()) {
            hashMap.put(c, 0);
        }
        // traverse the string s
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(hashMap.containsKey(c)) { // if the character appeared in hashmap, we count the times
                hashMap.put(c, hashMap.get(c) + 1);
            }else { //if the character not appeared in hashmap, we simply added it
                sb.append(c);
            }
        }
        // the worst time complexity of this nested loops is O(n) where n is the length of string s
        for(char c : order.toCharArray()) {
            for(int i = 0; i < hashMap.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
