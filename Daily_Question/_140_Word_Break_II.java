package Daily_Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _140_Word_Break_II {
    String s;
    HashSet<String> hashSet;
    List<String> res;
    StringBuilder sb;


    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        hashSet = new HashSet<>();
        hashSet.addAll(wordDict);
        res = new ArrayList<>();
        sb = new StringBuilder();

        backtracking(0, 0);

        return res;
    }

    public void backtracking(int begin, int current) {
        if(current == s.length()) {
            if(begin == s.length()) {
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        backtracking(begin, current + 1);

        if(hashSet.contains(s.substring(begin, current + 1))) {
            sb.append(s, begin, current + 1).append(" ");
            backtracking(current + 1, current + 1);
            sb.delete(sb.length() - (current + 1 - begin) - 1, sb.length());
        }
    }
}
