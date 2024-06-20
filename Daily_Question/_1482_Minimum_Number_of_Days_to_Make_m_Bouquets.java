package Daily_Question;

public class _1482_Minimum_Number_of_Days_to_Make_m_Bouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, left = Integer.MAX_VALUE, right = 0;
        if (m > n / k) return -1;
        for (int i = 0; i < n; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, temp = 0;
            for(int i = 0; i < n; i++) {
                if(mid >= bloomDay[i]) {
                    temp++;
                    if(temp == k) {
                        count++;
                        temp = 0;
                    }
                }else {
                    temp = 0;
                }
            }

            if(count < m) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
