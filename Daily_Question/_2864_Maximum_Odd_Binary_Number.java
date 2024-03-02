package Daily_Question;

public class _2864_Maximum_Odd_Binary_Number {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();

        int numsOfOne = -1;
        for(char c : s.toCharArray()) {
            if(c == '1') numsOfOne++;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(numsOfOne > 0) {
                sb.append('1');
                numsOfOne--;
            }else {
                sb.append('0');
            }
        }
        sb.append('1');

        return sb.toString();
    }
}
