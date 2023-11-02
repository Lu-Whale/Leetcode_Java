package LeetCode75.Binary_Search;

// https://leetcode.com/problems/guess-number-higher-or-lower/solutions/2819198/java-fastest-solution-100-binary-search/?envType=study-plan-v2&envId=leetcode-75
public class _374_Guess_Number_Higher_or_Lower {

    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        if(n == 1) return 1;
        if(guess(n)==0) return n;

        int first = 1, last = n;
        int mid;

        while(first<last){
            mid = first+(last-first)/2;
            int temp = guess(mid);

            if(temp==0) return mid;
            else if(temp==-1) last = mid;
            else first = mid;
        }
        return 0;
    }
}

