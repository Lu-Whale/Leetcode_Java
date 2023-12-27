package Top_Interview_150.Two_Pointers;

public class _167_Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {

        int lp = 0;
        int rp = numbers.length - 1;

        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];

            if(sum == target) {
                return new int[]{lp+1, rp+1};
            } else if(sum > target) {
                rp--;
            } else {
                lp++;
            }
        }

        return null;
    }
}
