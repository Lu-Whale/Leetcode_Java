package Daily_Question;

public class _1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        while (sb.length() > 1) {
            int i = sb.length() - 1;
            if(sb.charAt(i) == '1') {
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if(i >= 0) {
                    sb.setCharAt(i, '1');
                }else {
                    sb.insert(0, '1');
                }
            }else {
                sb.deleteCharAt(i);
            }
            res++;
        }

        return res;
    }
}
