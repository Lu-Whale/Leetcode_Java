package Daily_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1002_Find_Common_Characters {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String word : words) {
            int[] chars = new int[26];
            for(char c : word.toCharArray()) {
                String key = c + Integer.toString(chars[c - 'a']++);
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }
        }

        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) == words.length) {
                res.add(key.substring(0, 1));
            }
        }

        return res;
    }
}
