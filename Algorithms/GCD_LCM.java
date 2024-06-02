package Algorithms;

public class GCD_LCM {
    // 方法用于计算最大公约数
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    // 方法用于计算最小公倍数
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }


    public static void main(String[] args) {
        int a = 15;
        int b = 20;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm(a, b));
    }
}
