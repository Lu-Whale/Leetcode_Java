package Contest;

import java.util.HashSet;

public class _3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n - 1; i++) {
            hashSet.add(s.substring(i, i+2));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String r = sb.toString();
        for(int i = 0 ; i < n - 1; i++) {
            if(hashSet.contains(r.substring(i, i+2))) return true;
        }

        return false;
    }


}
