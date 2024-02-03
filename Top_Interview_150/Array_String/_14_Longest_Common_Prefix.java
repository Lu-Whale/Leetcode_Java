package Top_Interview_150.Array_String;

public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean flag = true;
        while (flag) {
            if(index >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++) {
                if(index >= strs[i].length()  || strs[i].charAt(index) != c) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(c);
                index++;
            }
        }

        return sb.toString();
    }
}
