package LeetCode75.Array_String;

//https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
public class _443_String_Compression {
    public static int compress(char[] chars) {
        int res = 0;

        for(int i = 0; i < chars.length; ) {
            char character = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == character) {
                count++;
                i++;
            }
            // we don't need to change the first character of chars
            chars[res++] = character;

            if(count > 1) {
                String s = "" + count;
                for(int j = 0; j < s.length(); j++) {
                    chars[res++] = s.charAt(j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
        System.out.println(chars);
    }
}
