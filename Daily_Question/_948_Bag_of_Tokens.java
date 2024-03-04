package Daily_Question;

import java.util.Arrays;
import java.util.Map;

// 3.4
public class _948_Bag_of_Tokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        int res = 0;

        Arrays.sort(tokens);
        int score = 0;
        int lp = 0, rp = tokens.length - 1;

        while (lp <= rp) {
            if(score == 0 || power >= tokens[lp]) { //face up
                if(power < tokens[lp]) break; // in this case, score=0 and power is smaller than current least small token
                power -= tokens[lp];
                score++;
                res = Math.max(score, res);
                lp++;
            }else { // face-down
                power += tokens[rp];
                score--;
                rp--;
            }
        }

        return res;
    }
}
