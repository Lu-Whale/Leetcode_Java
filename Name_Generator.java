import java.util.Scanner;

/**
 * Run and paste name copied from leetcode website, then copy the result as the java file name
 */
public class Name_Generator {
    private static String generator(String s) {
        StringBuilder stringBuilder = new StringBuilder("_");

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' || s.charAt(i) == '-' || s.charAt(i) == '(' || s.charAt(i) == ')') {
                stringBuilder.append('_');
            }else if(s.charAt(i) != '.') {
                stringBuilder.append(s.charAt(i));
            }
        }

        if(stringBuilder.charAt(stringBuilder.length() - 1) == '_') {
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(generator(s));
    }
}
