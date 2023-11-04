package Previous;

public class TT1 {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next()

        int[] A = {2, 3} ;
        int n = 23333;

        System.out.println(FindMax(A, n));
    }

    public static String FindMax(int[] A, int n) {

        // n
        String s = Integer.toString(n);

        StringBuilder stringBuilder = new StringBuilder();
        //
        int tmpi = -1;
        //iterate the number n
        for (int i = 0; i < s.length(); i++) {

            int tmpMax = 0;

            for (int j = 0; j < A.length; j++) {
                if (A[j] > tmpMax && A[j] <=(s.charAt(i) - 48)) {
                    tmpMax = A[j];
                }
            }

            stringBuilder.append(tmpMax);

            if (tmpMax < (s.charAt(i) - 48)) {
                tmpi = i;
                break;
            }

        }

        if (tmpi != -1) {
            int MaxInA = 0;
            for (int i = 0; i < A.length; i++) {
                MaxInA = Math.max(A[i], MaxInA);
            }
            for (int i = tmpi + 1; i < s.length(); i++) {
                stringBuilder.append(MaxInA);
            }
        }


        return stringBuilder.toString();
    }
}