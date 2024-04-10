package Daily_Question;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

// 4.10
public class _950_Reveal_Cards_In_Increasing_Order {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Deque<Integer> deque = new LinkedList<>();
        for(int i = n - 1; i >= 0; i--) {
            if(!deque.isEmpty()) {
                deque.offerFirst(deque.pollLast());
            }
            deque.offerFirst(deck[i]);
        }

        for(int i = 0; i < n; i++) {
            deck[i] = deque.pollFirst();
        }
        return deck;
    }
}
