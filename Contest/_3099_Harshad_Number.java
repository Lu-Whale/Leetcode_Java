package Contest;

public class _3099_Harshad_Number {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int temp = x;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}
