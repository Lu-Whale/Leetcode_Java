package Previous.MeiTuan;

import java.util.LinkedList;

public class 合并两个有序数组88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();

        for(int i = 0; i < Math.max(m, n); i++) {
            if(i < m) {
                queue1.add(nums1[i]);
            }

            if(i < n) {
                queue2.add(nums2[i]);
            }
        }

        for(int i = 0; i < m + n; i++) {
            if(queue1.peek() != null && queue2.peek() != null) {
                if(queue1.peek() <= queue2.peek()) {
                    nums1[i] = queue1.poll();
                }else {
                    nums1[i] = queue2.poll();
                }
            }else {
                if(queue1.peek() != null) {
                    nums1[i] = queue1.poll();
                }

                if(queue2.peek() != null) {
                    nums1[i] = queue2.poll();
                }
            }

        }
    }
    //从两个数组最后开始比较，然后填入数组1的最后
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
