package Problem_List;

public class _3084_Count_Substrings_Starting_and_Ending_with_Given_Character {
    public long countSubstrings(String s, char c) {
        long num = 0;
        for(char ch : s.toCharArray()) {
            if(ch == c) num++;
        }
        return  (num * (num - 1) / 2) + num;
    }
}
