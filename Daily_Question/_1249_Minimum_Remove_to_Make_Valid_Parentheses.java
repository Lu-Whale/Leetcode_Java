package Daily_Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class _1249_Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        HashSet<Integer> invalids = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            if(c == '(') {
                count++;
            }
            if(c == ')') {
                if(count > 0) {
                    count--;
                }else {
                    invalids.add(i);
                }
            }
        }
        for(int i = s.length() - 1; i >= 0 && count > 0; i--) {
            char c = s.charAt(i);
            if(c == '(') {
                invalids.add(i);
                count--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!invalids.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
