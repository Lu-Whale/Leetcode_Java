package Daily_Question;

public class _2540_Minimum_Common_Value {
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            }else if(nums2[p2] < nums1[p1]) {
                p2++;
            }else {
                return nums1[p1];
            }
        }

        return -1;
    }
}
