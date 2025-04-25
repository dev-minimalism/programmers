package io.pinkspider.stack;

import java.util.Stack;


// 올바른 괄호
public class Solution08 {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
