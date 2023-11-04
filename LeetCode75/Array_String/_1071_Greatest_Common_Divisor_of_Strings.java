package LeetCode75.Array_String;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
public class _1071_Greatest_Common_Divisor_of_Strings {
    public String gcdOfStrings(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        while (n !=0) {
            int tmp = n;
            n = m % n;
            m = tmp;
        }

        return str1.substring(0, m);
    }

    public static void main(String[] args) {
        System.out.println(12 % 15);
    }
}
