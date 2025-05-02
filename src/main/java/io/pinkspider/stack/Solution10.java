package io.pinkspider.stack;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution10 {

    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s;
        int answer = 0;

        A:
        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);

                // 열린 괄호
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 닫힌 괄호면
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
