package Problem_List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _76_Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
        }


        int left = 0;
        int right = 0;
        for(int i = 0; i < m; i++) {
            char curS = s.charAt(i);
            if(hashMap.containsKey(curS)) {
                hashMap.put(curS, hashMap.get(curS) - 1);
            }
            if(check(hashMap)) {
                right = i;
                break;
            }
        }

        if(!check(hashMap)) {
            return "";
        }
        for(; left <= right; left++) {
            char curL = s.charAt(left);
            if(hashMap.containsKey(curL)) {
                if(hashMap.get(curL) < 0) {
                    hashMap.put(curL, hashMap.get(curL) + 1);
                }else {
                    break;
                }
            }
        }

        int resL = left;
        int resR = right;
        int length = right - left;

        for(int i = right + 1; i < m; i++) {
            char cur = s.charAt(i);
            if(hashMap.containsKey(cur)) {
                hashMap.put(cur, hashMap.get(cur) - 1);

                //update left boundary
                for(; left <= i; left++) {
                    char curL = s.charAt(left);
                    if(hashMap.containsKey(curL)) {
                        if(hashMap.get(curL) < 0) {
                            hashMap.put(curL, hashMap.get(curL) + 1);
                        }else {
                            break;
                        }
                    }
                }

                int currentLength = i - left;
                if(currentLength < length) {
                    length = currentLength;
                    resL = left;
                    resR = i;
                }
            }

        }

        return s.substring(resL, resR + 1);
    }

    public static boolean check(HashMap<Character, Integer> hashMap) {
        for(int value : hashMap.values()) {
            if(value > 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String s = "EFAGADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
