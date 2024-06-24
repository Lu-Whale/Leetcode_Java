package Daily_Question;

import java.util.Deque;
import java.util.LinkedList;

public class _995_Minimum_Number_of_K_Consecutive_Bit_Flips {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (que.size() > 0 && i > que.peek() + k - 1) {
                que.removeFirst();
            }
            //1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            //2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (que.size() % 2 == nums[i]) {
                if (i + k > nums.length) return -1;
                que.add(i);
                res += 1;
            }
        }
        return res;
    }

}
