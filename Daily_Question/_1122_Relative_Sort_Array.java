package Daily_Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _1122_Relative_Sort_Array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] res = new int[n1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n2; i++) {
            hashMap.put(arr2[i], i);
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for(int i = 0; i < n1; i++) {
            if(hashMap.containsKey(arr1[i])) {
                pq1.offer(arr1[i]);
            }else {
                pq2.offer(arr1[i]);
            }
        }

        int index = 0;
        while (!pq1.isEmpty()) {
            res[index++] = pq1.poll();
        }
        while (!pq2.isEmpty()) {
            res[index++] = pq2.poll();
        }

        return res;
    }
}
