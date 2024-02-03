package Top_Interview_150.Array_String;

public class _58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean flag = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                flag = true;
                res++;
            }
            if (flag && s.charAt(i) == ' ') {
                break;
            }
        }
        return res;
    }
}
