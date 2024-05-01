package Daily_Question;

public class _2000_Reverse_Prefix_of_Word {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(c);
            if(c == ch && !flag) {
                sb.reverse();
                flag = true;
            }
        }

        return sb.toString();
    }
}
