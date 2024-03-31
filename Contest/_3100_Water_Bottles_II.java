package Contest;

public class _3100_Water_Bottles_II {
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        int full = numBottles, empty = 0;
        while (empty >= numExchange || full > 0) {
            if(full > 0) {
                res += full;
                empty += full;
                full = 0;
            }else {
                empty -= numExchange;
                full++;
                numExchange++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int numBottles = 10;
        int numExchange = 3;
        maxBottlesDrunk(numBottles, numExchange);
    }
}
