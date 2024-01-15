package Top_Interview_150.Array_String;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
public class _274_H_Index {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int paper = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            paper++;
            if(paper > citations[i]) {
                return paper - 1;
            }
            if(paper == citations[i]) {
                return paper;
            }
        }

        return paper;
    }

    public static void main(String[] args) {
        int[] citations = {0};
        hIndex(citations);
    }
}
