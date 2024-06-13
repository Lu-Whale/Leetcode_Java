package Daily_Question;

import java.util.Arrays;

public class _2037_Minimum_Number_of_Moves_to_Seat_Everyone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0, n = seats.length;

        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i = 0; i < n; i++) {
            res += Math.abs(students[i] - seats[i]);
//            students[i] = seats[i];
        }

        return res;
    }
}
