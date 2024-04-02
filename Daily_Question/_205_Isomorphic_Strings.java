package Daily_Question;

import java.util.HashMap;
import java.util.HashSet;

public class _205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        // key -> cs, value -> ct
        HashMap<Character, Character> hashMap = new HashMap<>();
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(!hashMap.containsKey(cs)) {
                if(hashSet.contains(ct)) return false;
                hashSet.add(ct);
                hashMap.put(cs, ct);
            }else {
                if(hashMap.get(cs) != ct) {
                    return false;
                }
            }
        }
        return true;
    }
}
