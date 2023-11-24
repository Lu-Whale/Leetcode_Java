package LeetCode75.Queue;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/dota2-senate/submissions/?envType=study-plan-v2&envId=leetcode-75
public class _649_Dota2_Senate {
    public String predictPartyVictory(String senate) {
        if(senate.length() == 0) {
            return null;
        }

        Queue<Character> senators = new LinkedList<>();

        int numsR = 0, numsD = 0;
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                senators.offer('R');
                numsR++;
            }else {
                senators.offer('D');
                numsD++;
            }
        }
        //numbers of senator lost their right
        int countR = 0, countD = 0;
        while (numsD > 0 && numsR > 0) {
            char curr = senators.poll();

            if(curr == 'R') {
                if(countR > 0) {
                    countR--;
                    numsR--;
                }else {
                    countD++;
                    senators.offer('R');
                }
            }else {
                if(countD > 0) {
                    countD--;
                    numsD--;
                }else {
                    countR++;
                    senators.offer('D');
                }
            }
        }

        return numsD == 0 ? "Radiant" : "Dire";
    }
}
