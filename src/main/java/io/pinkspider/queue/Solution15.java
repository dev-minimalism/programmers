package io.pinkspider.queue;

import java.util.ArrayDeque;

// 요세푸스 문제
public class Solution15 {

    public int solution(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.addLast(i + 1);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }

        return queue.pollFirst();
    }
}
