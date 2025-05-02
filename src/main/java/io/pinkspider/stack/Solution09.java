package io.pinkspider.stack;

import java.math.BigDecimal;
import java.util.Stack;


// 10진수를 2진수로 변환하기
public class Solution09 {

    public static String solution(int decimal) {
        StringBuilder answer = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.toString();
    }
}
