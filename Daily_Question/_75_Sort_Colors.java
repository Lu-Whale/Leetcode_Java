package Daily_Question;

public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num : nums) {
            count[num]++;
        }
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) nums[index++] = i;
        }
    }
}
