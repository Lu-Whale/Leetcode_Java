package Top_Interview_150.Stack;

import java.util.Stack;

public class _71_Simplify_Path {
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path.charAt(0));

        for(int i = 1; i < path.length(); i++) {
            if(path.charAt(i) == '/') {
                if(path.charAt(i-1) == '/') {
                    continue;
                }else {
                    stack.push(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            stringBuilder.append(path.charAt(i));
        }
        if(!stringBuilder.toString().equals("/")) {
            stack.push(stringBuilder.toString());
        }

        Stack<String> result = new Stack<>();
        int countPop = 0;
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if(s.equals("/.")) {
                continue;
            }else if(s.equals("/..")) {
               countPop++;
            }else {
                if(countPop > 0) {
                    countPop--;
                }else {
                    result.push(s);
                }
            }
        }
        stringBuilder = new StringBuilder();
        while (!result.isEmpty()) {
            stringBuilder.append(result.pop());
        }

        if(stringBuilder.length() == 0) {
            stringBuilder.append('/');
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";

        System.out.println(simplifyPath(path));
    }
}
