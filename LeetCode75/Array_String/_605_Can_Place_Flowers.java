package LeetCode75.Array_String;

// https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
public class _605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int space = 0;

        int boundary = flowerbed[0] == 0 ? 0 : 1;

        for(int i = 0; i < flowerbed.length; i++) {

            if(flowerbed[i] == 1) {
                boundary++;
                if(boundary == 2) {
                    if(space >= 3) {
                        int mod = space % 2;
                        n -= mod == 0 ? space/2 - 1 : space/2;
                    }

                }else {
                    n -= space/2;
                }
                space = 0;
                if(boundary == 2) boundary--;
            }else {
                space++;
            }
        }

        if(space != 0) {
            if(boundary == 1) {
                n -= space/2;
            }else {
                int mod = space % 2;
                n -= mod == 0 ? space/2 : space/2 + 1;
            }
        }

        return n <= 0;
    }
}
