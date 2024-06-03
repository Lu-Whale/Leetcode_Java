package Daily_Question;

public class _2486_Append_Characters_to_String_to_Make_Subsequence {
    public int appendCharacters(String s, String t) {
        int indexS = 0, indexT = 0;
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            boolean flag = false;
            for(int j = indexS; j < s.length(); j++) {
                if(s.charAt(j) == c) {
                    flag = true;
                    indexS = j + 1;
                    break;
                }
            }
            if(!flag) break;
            indexT++;
        }

        return t.length() - indexT;
    }
}
