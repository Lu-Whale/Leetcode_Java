package Top_Interview_150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(2 * n, n, 0, new StringBuilder(), res);
        return res;
    }

    public void dfs(int size, int left, int right, StringBuilder stringBuilder, List<String> res) {

        if(stringBuilder.length() == size) {
            res.add(stringBuilder.toString());
            return;
        }

        if(left > 0) {
            stringBuilder.append('(');
            left--;
            right++;
            dfs(size, left, right, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            left++;
            right--;
        }

        if(right > 0) {
            stringBuilder.append(')');
            dfs(size, left, --right, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

class Solution {
    StringBuffer path = new StringBuffer();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return res;
    }

    void backtracking(int l, int r, int n) {
        if (l > n || l < r) { // 剪枝
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path.toString());
        }
        for (int i = 0; i < 2; i++) { // 将括号看作大小为 2 的数组，求他们的有效组合，括号个数决定了树的深度
            if (i == 0) {
                path.append("(");
                backtracking(l + 1, r, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
            if (i == 1) {
                path.append(")");
                backtracking(l, r + 1, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
        }
    }
}
