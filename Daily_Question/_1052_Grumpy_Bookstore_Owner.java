package Daily_Question;

public class _1052_Grumpy_Bookstore_Owner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int sum = 0;
        for(int i = 0; i < minutes; i++) {
            if(grumpy[i] == 1) sum += customers[i];
        }

        int maxSum = sum, maxIndex = 0;
        for(int l = 0, r = minutes; r < n; l++, r++) {
            if(grumpy[l] == 1) sum -= customers[l];
            if(grumpy[r] == 1) sum += customers[r];
            if(sum > maxSum) {
                maxSum = sum;
                maxIndex = l + 1;
            }
        }
        for(int i = maxIndex; i < maxIndex + minutes && i < n; i++) {
            grumpy[i] = 0;
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0) res += customers[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] customers = {2,6,6,9};
        int[] grumpy = {0,0,1,1};
        int minutes = 1;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
}
