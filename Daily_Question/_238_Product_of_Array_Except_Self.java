package Daily_Question;

public class _238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int preProduct = 1;
        for (int i = 0; i < n; i++) {
            prefix[i] = preProduct;
            preProduct *= nums[i];
        }
        int sufProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = sufProduct;
            sufProduct *= nums[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}
