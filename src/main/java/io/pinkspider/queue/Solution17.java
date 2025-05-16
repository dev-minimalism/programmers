package io.pinkspider.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

// 카드 뭉치
public class Solution17 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> deque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> deque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalDeque.isEmpty()) {

            if (!deque1.isEmpty() && deque1.peekFirst().equals(goalDeque.peekFirst())) {
                deque1.pollFirst();
                goalDeque.pollFirst();
            } else if (!deque2.isEmpty() && deque2.peekFirst().equals(goalDeque.peekFirst())) {
                deque2.pollFirst();
                goalDeque.pollFirst();
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    // 굳이 queue 안쓰고..
    public String solution2(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx2 = 0;

        for (int i = 0; i < goal.length; i++) {
            String target = goal[i];

            if (cardIdx1 < cards1.length && target.equals(cards1[cardIdx1])) {
                cardIdx1++;
            } else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2])) {
                cardIdx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
