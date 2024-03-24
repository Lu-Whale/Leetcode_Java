package Contest;

public class _3091_Apply_Operations_to_Make_Sum_of_Array_Greater_Than_or_Equal_to_k {
    public int minOperations(int k) {
        int res = Integer.MAX_VALUE;
        int num = 1;
        int o1 = 0;
        while (num <= k) {
            int o2 = k % num == 0 ? (k / num) - 1 : k / num;
            if(o1 + o2 > res) break;
            res = o1 + o2;
            o1++;
            num++;
        }

        return res;
    }
}
