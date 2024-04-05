package Daily_Question;

public class _1544_Make_The_String_Great {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(sb.length() == 0 || Math.abs(c - sb.charAt(sb.length() - 1)) != 32) {
                sb.append(c);
            }else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char a = 'a';
        char A = 'A';
        char z = 'z';
        char Z = 'Z';
        System.out.println(A - a);
        System.out.println(Z - z);
    }
}
