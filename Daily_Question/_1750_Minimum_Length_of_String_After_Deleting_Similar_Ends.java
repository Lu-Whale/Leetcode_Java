package Daily_Question;

public class _1750_Minimum_Length_of_String_After_Deleting_Similar_Ends {
    public int minimumLength(String s) {
        int lp = 0, rp = s.length() - 1;

        while (s.charAt(lp) == s.charAt(rp) && lp < rp) {
            char c = s.charAt(lp);
            //prefix
            lp++;
            while (s.charAt(lp) == c && lp < rp) {
                lp++;
            }
            //suffix
            rp--;
            while (s.charAt(rp) == c && lp < rp) {
                rp--;
            }
        }

        if(rp > lp) {
            return rp - lp + 1;
        }else if(rp < lp) {
            return 0;
        }else {
            return 1;
        }
    }
}

class Solution_1750 {
    public int minimumLength(String s) {

        char[] ch = s.toCharArray();
        int n = ch.length;
        int lp = 0;
        int rp = n-1;
        while(rp > lp){
            if(ch[lp] != ch[rp]) break;
            char c = ch[lp];
            while(rp >= lp && ch[lp] == c) lp++;
            while(rp >= lp && ch[rp] == c) rp--;
        }
        return rp-lp+1;
    }
}