package Top_Interview_150.Multidimensional_DP;

public class _5_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        String res = "";

        for(int i = 0; i < s.length(); i++) {
            res = getString(s, res, i, i);
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                res = getString(s, res, i, i + 1);
            }

        }

        return res;
    }

    private String getString(String s, String res, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        res = (right - left - 1) > res.length() ? s.substring(left + 1, right) : res;
        return res;
    }


    public static void main(String[] args) {
        String s = "bababa";

        System.out.println(s.substring(0, 2));
    }
}
