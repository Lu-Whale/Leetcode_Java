package Top_Interview_150.HashMap;

import java.util.HashMap;

public class _242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(!hashMap.containsKey(c) || hashMap.get(c) <= 0) {
                return false;
            }else {
                hashMap.put(c, hashMap.get(c) - 1);
            }
        }

        for(int i : hashMap.values()) {
            if(i > 0) {
                return false;
            }
        }

        return true;
    }
}
