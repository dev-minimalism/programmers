package io.pinkspider.stack;

import java.util.Stack;

// 주식 가격
public class Solution12 {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - j - 1;
        }

        return answer;
    }
}
