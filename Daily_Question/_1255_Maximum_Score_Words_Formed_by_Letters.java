package Daily_Question;

import java.util.HashMap;

public class _1255_Maximum_Score_Words_Formed_by_Letters {
    int res;
    String[] words;
    int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        res = 0;
        this.words = words;
        this.score = score;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char letter : letters) {
            hashMap.put(letter, hashMap.getOrDefault(letter, 0) + 1);
        }

        backtracking(0, 0, hashMap);

        return res;
    }

    public void backtracking(int i, int currScore, HashMap<Character, Integer> hashMap) {
        if(i == words.length) {
            res = Math.max(res, currScore);
            return;
        }

        backtracking(i + 1, currScore, hashMap);

        if(canForm(words[i], hashMap)) {
            currScore += countScore(words[i], hashMap);
            backtracking(i + 1, currScore, hashMap);
            recover(words[i], hashMap);
        }

    }

    public boolean canForm(String word, HashMap<Character, Integer> hashMap) {
        HashMap<Character, Integer> temp = new HashMap<>(hashMap);

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!temp.containsKey(c) || temp.get(c) <= 0) {
                return false;
            }else {
                temp.put(c, temp.get(c) - 1);
            }
        }

        return true;
    }

    public int countScore(String word, HashMap<Character, Integer> hashMap) {
        int s = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            s += score[c - 'a'];
            hashMap.put(c, hashMap.get(c) - 1);
        }

        return s;
    }

    public void recover(String word, HashMap<Character, Integer> hashMap) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            hashMap.put(c, hashMap.get(c) + 1);
        }
    }
}
