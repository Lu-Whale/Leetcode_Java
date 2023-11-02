import java.util.Scanner;

public class name_generator {
    private static String generator(String s) {
        StringBuilder stringBuilder = new StringBuilder("_");

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' || s.charAt(i) == '-') {
                stringBuilder.append('_');
            }else if(s.charAt(i) != '.') {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(generator(s));
    }
}
