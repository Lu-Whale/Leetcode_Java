package Daily_Question;

public class _58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean recording = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c != ' ') {
                recording = true;
                res++;
            }
            if(c == ' ' && recording) break;
        }

        return res;
    }
}
