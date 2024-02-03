package Top_Interview_150.Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _30_Substring_with_Concatenation_of_All_Words {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        int wordLen = words[0].length();
        int sLen = s.length();

        HashMap<String, Integer> wordsHash = new HashMap<>();
        for(String word : words) {
            wordsHash.put(word, wordsHash.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i < wordLen; i++) {
            if(i + n * wordLen > sLen) {
                break;
            }

            HashMap<String, Integer> subStrings = new HashMap<>();
            int left = i;
            for(int j = i; j + wordLen <= s.length(); j += wordLen) {
                int right = j + wordLen;
                String subString = s.substring(j, right);
                if(wordsHash.containsKey(subString)) {
                    subStrings.put(subString, subStrings.getOrDefault(subString, 0) + 1);
                    while (subStrings.get(subString) > wordsHash.get(subString)) {
                        String delete = s.substring(left, left + wordLen);
                        subStrings.put(delete, subStrings.get(delete) - 1);
                        left += wordLen;
                    }
                    if(right - left == wordLen * n) {
                        res.add(left);
                        String delete = s.substring(left, left + wordLen);
                        subStrings.put(delete, subStrings.get(delete) - 1);
                        left += wordLen;
                    }
                }else {
                    left = right;
                    subStrings.clear();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println(findSubstring(s, words));
    }

    // Time out solution
    public List<Integer> findSubstringTimeOut(String s, String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        boolean[] used = new boolean[words.length];
        StringBuilder stringBuilder = new StringBuilder();
        int n = words.length * words[0].length();
        dfs(words,stringBuilder, n, used, hashSet);

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i + n - 1 < s.length(); i++) {
            if(hashSet.contains(s.substring(i, i + n))) {
                res.add(i);
            }
        }

        return res;
    }
    public void dfs(String[] words, StringBuilder stringBuilder, int n, boolean[] used, HashSet<String> hashSet) {
        if(stringBuilder.length() == n && !hashSet.contains(stringBuilder.toString())) {
            hashSet.add(stringBuilder.toString());
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!used[i]) {
                stringBuilder.append(words[i]);
                used[i] = true;

                dfs(words, stringBuilder, n, used, hashSet);

                stringBuilder.delete(stringBuilder.length() - words[i].length(), stringBuilder.length());
                used[i] = false;
            }
        }
    }

    // SOLUTION 2
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hasWords.get(word) > allWords.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }

            }

        }
        return res;
    }
}
