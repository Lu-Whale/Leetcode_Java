package Daily_Question;

import java.util.*;

public class _752_Open_the_Lock {
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)) return 0;

        HashSet<String> dead = new HashSet<>();
        for(String deadend: deadends) {
            dead.add(deadend);
        }
        if(dead.contains("0000")) return -1;

        int step = 0;
        Queue<String> queue =new LinkedList<>();
        queue.offer("0000");
        HashSet<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String status = queue.poll();
                for(String nextStatus : get(status)) {
                    if(!visited.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if(nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        visited.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> get(String status) {
        List<String> list = new ArrayList<>();
        char[] array = status.toCharArray();
        for(int i = 0; i < 4; i++) {
            char num = array[i];
            array[i] = num == '0' ? '9' : (char) (num - 1);
            list.add(new String(array));
            array[i] = num == '0' ? '9' : (char) (num + 1)
            list.add(new String(array));
            array[i] = num;
        }

        return list;
    }
}
