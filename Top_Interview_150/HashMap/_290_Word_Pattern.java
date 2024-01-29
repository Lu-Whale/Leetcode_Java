package Top_Interview_150.HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class _290_Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        HashMap<String, Character> hashMap = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(hashMap.containsKey(words[i])) {
                if(hashMap.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            }else {
                if(hashMap.containsValue(pattern.charAt(i))) {
                    return false;
                }
                hashMap.put(words[i], pattern.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String[] words = s.split(" ");
        System.out.println(Arrays.toString(words));
    }
}
