package Daily_Question;

public class _1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
        int n = arr.length, res = 0;
        int[] prefix = new int[n];
        int tmp = 0;
        for(int i = 0; i < n; i++) {
            prefix[i] = tmp ^ arr[i];
            tmp = prefix[i];
        }

        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                if((prefix[i] ^ arr[i]) == prefix[j]) {
                    res += (j - i);
                }
            }
        }

        return res;
    }
}
