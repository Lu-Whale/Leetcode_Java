package Top_Interview_150.Array_String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _68_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        Queue<String> tmp = new LinkedList<>();
        int stringWidth = 0;
        int space = 0;

        int index = 0;
        while (index < words.length) {
            if(tmp.isEmpty()) {
                tmp.offer(words[index]);
                stringWidth += words[index].length();
                index++;
            }else {
                if(stringWidth + space + words[index].length() + 1 <= maxWidth) {
                    tmp.offer(words[index]);
                    stringWidth += words[index].length();
                    space++;
                    index++;
                }else {
                    StringBuilder stringBuilder = new StringBuilder();
                    if(tmp.size() == 1) {
                        stringBuilder.append(tmp.poll());
                        while (stringBuilder.length() < maxWidth) {
                            stringBuilder.append(" ");
                        }
                    }else {
                        int slots = (maxWidth - stringWidth) / space;
                        int leftSlots = (maxWidth - stringWidth) % space;
                        while (!tmp.isEmpty()) {
                            stringBuilder.append(tmp.poll());
                            if(space > 0) {
                                for(int i = 0; i < (slots + (leftSlots > 0 ? 1 : 0)); i++) {
                                    stringBuilder.append(" ");
                                }
                                space--;
                                leftSlots--;
                            }
                        }
                    }
                    stringWidth = 0;
                    res.add(stringBuilder.toString());
                }
            }
        }
        // add last
        StringBuilder stringBuilder = new StringBuilder();
        while (!tmp.isEmpty()) {
            stringBuilder.append(tmp.poll());
            if(space > 0) {
                stringBuilder.append(" ");
                space--;
            }
        }
        while (stringBuilder.length() < maxWidth) {
            stringBuilder.append(" ");
        }
        res.add(stringBuilder.toString());

        return res;
    }
}
