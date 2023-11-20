package LeetCode75.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_Letter_Combinations_of_a_Phone_Number {

    List<String> res = new ArrayList<>();
    String[] phone = {"*", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 ) {
            return res;
        }
        dfs(digits, new StringBuilder(), 0);

        return res;
    }

    public void dfs(String digits, StringBuilder letter, int index) {
        if(index == digits.length()) {
            res.add(letter.toString());
            return;
        }

        char number = digits.charAt(index);
        String str = phone[number - '0'];

        for(int i = 0; i < str.length(); i++) {
            letter.append(str.charAt(i));
            dfs(digits, letter, index + 1);
            //backtracking
            letter.deleteCharAt(letter.length() -1);
        }
    }

    // use String instead of StringBuilder
//    private void findCombination(String digits, int index, String s){
//
//        if(index == digits.length()){
//            res.add(s);
//            return;
//        }
//
//        Character c = digits.charAt(index);
//        String letters = letterMap[c - '0'];
//        for(int i = 0 ; i < letters.length() ; i ++){
//            findCombination(digits, index+1, s + letters.charAt(i));
//        }
//
//        return;
//    }

}
