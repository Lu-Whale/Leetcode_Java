package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _131_Palindrome_Partitioning {
    List<List<String>> res;
    List<String> path;
    String s;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        this.s = s;

        dfs(0, 0);

        return res;
    }

    // start 表示当前这段回文子串的开始位置
    public void dfs(int curr, int start) {
        if(curr == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 不选 i 和 i+1 之间的逗号（i=n-1 时一定要选）
        if(curr < s.length() - 1) {
            dfs(curr + 1, start);
        }

        // 选 i 和 i+1 之间的逗号（把 s[i] 作为子串的最后一个字符）
        if(checkPalindrome(start, curr)) {
            path.add(s.substring(start, curr+1));
            dfs(curr + 1, curr + 1); // 下一个子串从 i+1 开始
            path.remove(path.size() - 1); // backtracking
        }
    }

    public boolean checkPalindrome(int left, int right) {
        while (left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
