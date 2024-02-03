package Top_Interview_150.Array_String;

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }
        for(int i = 0; i + needle.length() <= haystack.length(); i++) {
            if(haystack.startsWith(needle, i)) {
                return i;
            }
        }

        return -1;
    }
}
