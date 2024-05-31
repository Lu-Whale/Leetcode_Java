package Daily_Question;

import java.util.HashSet;

public class _260_Single_Number_III {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            if(!hashSet.contains(num)) {
                hashSet.add(num);
            }else {
                hashSet.remove(num);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for(int val : hashSet){
            res[i++] = val;
        }

        return res;
    }
}

class Solution_260_XOR {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int x : nums) {
            xorAll ^= x;
        }
        int flag = xorAll & (-xorAll);
        int[] ans = new int[2];
        for (int num : nums) {
            if ( (num & flag) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}

class Solution_260_XOR_2 {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int x : nums) {
            xorAll ^= x;
        }
        int tz = Integer.numberOfTrailingZeros(xorAll);
        int[] ans = new int[2];
        for (int x : nums) {
            ans[x >>> tz & 1] ^= x;
        }
        return ans;
    }
}

