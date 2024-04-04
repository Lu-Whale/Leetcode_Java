package Daily_Question;

import java.util.Stack;

public class _1614_Maximum_Nesting_Depth_of_the_Parentheses {
    public int maxDepth(String s) {
        int res = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                temp++;
                res = Math.max(res, temp);
            }
            if(c == ')') {
                temp--;
            }
        }

        return res;
    }
}
