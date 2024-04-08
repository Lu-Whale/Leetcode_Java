package Daily_Question;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 4.8
public class _1700_Number_of_Students_Unable_to_Eat_Lunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        int circular = 0;
        int square = 0;
        for(int i = 0; i < n; i++) {
            if(students[i] == 0) {
                circular++;
            }else {
                square++;
            }
        }

        for(int i = 0; i < n; i++) {
            if(sandwiches[i] == 0) {
                if(circular > 0) {
                    circular--;
                }else {
                    break;
                }
            }else {
                if(square > 0) {
                    square--;
                }else {
                    break;
                }
            }
        }

        return Math.max(circular, square);
    }
}
