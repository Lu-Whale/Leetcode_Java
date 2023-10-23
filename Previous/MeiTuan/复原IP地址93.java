package Previous.MeiTuan;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int first = 0;
        int point = 0;
        while (first <= 255) {
            first = 10 * first + s.charAt(point);

        }


        return result;
    }
}
