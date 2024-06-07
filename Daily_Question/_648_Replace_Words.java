package Daily_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _648_Replace_Words {
    public static String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> hashSet = new HashSet<>(dictionary);
        int n = sentence.length();

        StringBuilder sb = new StringBuilder();
        int left = 0;
        for(int right = 0; right < n; right++) {
            char c = sentence.charAt(right);
            if(c == ' ') {
                sb.append(sentence, left, right + 1);
                left = right + 1;
            }
            if(hashSet.contains(sentence.substring(left, right + 1))) {
                sb.append(sentence, left, right + 1);
                while (right < n && sentence.charAt(right) != ' ') {
                    right++;
                }
                if(right < n) sb.append(' ');
                left = right + 1;
            }
        }
        if(left < n) sb.append(sentence, left, n);

        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");

        String sentence = "the cattle was rattled by the battery ttttt";
        String s = "aadsfasf absbs bbab cadsfafs";

        System.out.println(replaceWords(dictionary, s));
    }
}

class Solution_648 {
    class Node {
        boolean isEnd;
        Node[] tns = new Node[26];
    }
    Node root = new Node();
    void add(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new Node();
            p = p.tns[u];
        }
        p.isEnd = true;
    }
    String query(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) break;
            if (p.tns[u].isEnd) return s.substring(0, i + 1);
            p = p.tns[u];
        }
        return s;
    }
    public String replaceWords(List<String> ds, String s) {
        for (String str : ds) add(str);
        StringBuilder sb = new StringBuilder();
        for (String str : s.split(" ")) sb.append(query(str)).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
}
