package Daily_Question;

public class _1208_Get_Equal_Substrings_Within_Budget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(), res = 0;
        int[] costs = new int[n];
        for(int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, currCost = 0;
        for(int right = 0; right < n; right++) {
            currCost += costs[right];
            while (left <= right && currCost > maxCost) {
                currCost -= costs[left++];
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
