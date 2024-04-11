package Daily_Question;


import java.util.ArrayDeque;
import java.util.Deque;

//4.11
public class _402_Remove_K_Digits {
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > num.charAt(i)) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(num.charAt(i));
        }
        while (!deque.isEmpty() && k > 0) {
            deque.pollLast();
            k--;
        }

        if(deque.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        int size = deque.size();
        for(int i = 0; i < size; i++) {
            char c = deque.pollFirst();
            if(c != '0' || sb.length() > 0) {
                sb.append(c);
            }
        }
        if(sb.length() == 0) return "0";

        return sb.toString();

    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
}
