package Top_Interview_150.HashMap;

import java.util.HashMap;
import java.util.Map;

public class _205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        int signS = 0;
        int signT = 0;
        HashMap<Character, Integer> hashMapS = new HashMap<>();
        HashMap<Character, Integer> hashMapT = new HashMap<>();
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            if(!hashMapS.containsKey(cS)) {
                hashMapS.put(cS, signS++);
            }
            sbS.append(hashMapS.get(cS));

            char cT = t.charAt(i);
            if(!hashMapT.containsKey(cT)) {
                hashMapT.put(cT, signT++);
            }
            sbT.append(hashMapT.get(cT));

            if(!sbS.toString().equals(sbT.toString())) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            // 说明有一对多的映射关系，则返回 false ；
            // 对于映射 b -> a 也同理
            if (s2t.containsKey(a) && s2t.get(a) != b ||
                    t2s.containsKey(b) && t2s.get(b) != a)
                return false;
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }
}

