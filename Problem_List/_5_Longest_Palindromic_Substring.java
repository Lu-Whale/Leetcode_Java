package Problem_List;

public class _5_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {

        int longest = 1;
        int startIndex = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                int lp = i - 1;
                int rp = i + 2;
                int length = 2;
                while (lp >= 0 && rp < s.length() && s.charAt(lp) == s.charAt(rp)) {
                    length += 2;
                    lp--;
                    rp++;
                }
                if(length > longest) {
                    longest = length;
                    startIndex = lp + 1;
                }
            }
            int lp = i - 1;
            int rp = i + 1;
            int length = 1;
            while (lp >= 0 && rp < s.length() && s.charAt(lp) == s.charAt(rp)) {
                length += 2;
                lp--;
                rp++;
            }
            if(length > longest) {
                longest = length;
                startIndex = lp + 1;
            }
        }

        return s.substring(startIndex, startIndex + longest);
    }
}
