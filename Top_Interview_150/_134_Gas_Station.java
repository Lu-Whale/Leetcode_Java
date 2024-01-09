package Top_Interview_150;

public class _134_Gas_Station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for(int i = 0; i < n; i++) {
            int station = i;
            int tank = gas[station];
            while (tank - cost[station] >= 0) {
                int nextStation = (station + 1) % n;
                tank = tank - cost[station] + gas[nextStation];
                station = nextStation;

                if(station == i) {
                    return i;
                }
            }

            if(station < i) {
                return -1;
            }
            i = station;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));

        int[] gas1 = {2, 3, 4};
        int[] cost1 = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas1, cost1));
    }
}
