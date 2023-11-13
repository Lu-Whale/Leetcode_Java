package Problem_List;

import java.util.*;

public class _253_Meeting_Rooms_II {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        HashSet<int[]> rooms = new HashSet<>();

        for(int[] meeting : intervals) {
            priorityQueue.add(meeting);
        }

        // 0 -> meeting start, 1 -> meeting end
        while (!priorityQueue.isEmpty()) {
            int[] meeting = priorityQueue.poll();

            // when earliest meeting need a meeting room
            if(rooms.isEmpty()) {
                rooms.add(meeting);
            }

            // locate meeting
            boolean meetingLocated = false;
            for(int[] room : rooms) {
                if(meeting[0] >= room[1]) {
                    room[1] = meeting[1];
                    meetingLocated = true;
                    break;
                }
            }
            if(!meetingLocated) {
                rooms.add(meeting);
            }
        }

        return rooms.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1293,2986},{848,3846},{4284,5907},{4466,4781},{518,2918},{300,5870}};

        int i = minMeetingRooms(intervals);
        System.out.println(i);

    }
}
