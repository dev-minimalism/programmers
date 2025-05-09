package io.pinkspider.stack;

import java.util.Arrays;
import java.util.Stack;

// 표 편집
public class Solution14 {

    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k++;

        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }

    public String otherSolution(int n, int k, String[] cmd) {
        Node cur = initList(n);
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        for (String s : cmd) {
            char command = s.charAt(0);
            int distance;
            switch (command) {
                case 'U':
                    distance = getDistance(s);
                    for (int i = 0; i < distance; i++) {
                        cur = cur.prev;
                    }
                    break;
                case 'D':
                    distance = getDistance(s);
                    for (int i = 0; i < distance; i++) {
                        cur = cur.next;
                    }
                    break;
                case 'C':
                    stack.add(cur);
                    cur.remove();
                    cur = cur.hasNext() ? cur.next : cur.prev;
                    break;
                case 'Z':
                    stack.pop().restore();
                    break;
            }
        }

        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!stack.isEmpty()) {
            answer.setCharAt(stack.pop().idx, 'X');
        }
        return answer.toString();
    }

    private int getDistance(String s) {
        return Integer.parseInt(s.substring(2));
    }

    private static class Node {
        int idx;
        Node prev, next;

        public Node(int idx) {
            this.idx = idx;
        }

        boolean hasNext() {
            return next.idx != -1;
        }

        public void restore() {
            prev.next = this;
            next.prev = this;
        }

        public void remove() {
            prev.next = next;
            next.prev = prev;
        }
    }

    private Node initList(int n) {
        Node start = new Node(-1);
        Node prev = start;
        Node cur = null;
        for (int i = 0; i < n; i++) {
            cur = new Node(i);
            prev.next = cur;
            cur.prev = prev;
            prev = cur;
        }
        cur.next = new Node(-1); //end노드 설정
        return start.next; //첫번째 노드 반환
    }
}
