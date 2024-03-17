package Problem_List;

public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(sum % 2);
            ca = sum / 2;
        }
        res.append(ca == 1 ? ca : "");
        return res.reverse().toString();

    }
}

class Solution_67 {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();     // 存储结果
        int add = 0;    // 进位位
        int i = a.length() - 1;   // a的最后一位，即表示的二进制最低位
        int j = b.length() - 1;   // b的最后一位，即表示的二进制最低位
        // 从最低位开始模拟相加，逆序生成
        while (i >= 0 || j >= 0)
        {
            int aDigit = i == -1 ? 0 : a.charAt(i--) - '0';    // 获取当前位，不够则补0
            int bDigit = j == -1 ? 0 : b.charAt(j--) - '0';
            int sDigit = aDigit ^ bDigit ^ add;         // 位运算计算当前位的和
            add = (aDigit & bDigit) | (aDigit & add) | (bDigit & add);  // 位运算计算当前进位位
            sum.append(sDigit);   // 更新当前位
        }
        if(add == 1)sum.append(1);    // 已有位加完后，进位位为1，说明产生高位
        return sum.reverse().toString();    // 逆序反转
    }
}