package Daily_Question;

public class _3110_Score_of_a_String {
    public int scoreOfString(String s) {
        int res = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return res;
    }
}
