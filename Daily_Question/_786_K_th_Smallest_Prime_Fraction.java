package Daily_Question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _786_K_th_Smallest_Prime_Fraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Fraction> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));

        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                Fraction fraction = new Fraction(arr[i], arr[j]);
                if(pq.size() < k) {
                    pq.offer(fraction);
                }else {
                    if(fraction.compareTo(pq.peek()) <= 0) {
                        pq.offer(fraction);
                        pq.poll();
                    }
                }
            }
        }

        return new int[]{pq.peek().numerator, pq.peek().denominator};
    }
}

class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public int compareTo(Fraction other) {
        // 将两个分数通分，并比较分子
        long num1 = (long) this.numerator * other.denominator;
        long num2 = (long) other.numerator * this.denominator;
        return Long.compare(num1, num2);
    }
}
