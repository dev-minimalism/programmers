package io.pinkspider.stack;

import java.util.Stack;

// 크레인 인형 뽑기 게임
public class Solution13 {

    public int solution(int[][] board, int[] moves) { // int[][] board, int[] moves
        int answer = 0; // 사라진 인형 갯수

        Stack<Integer>[] lanes = new Stack[board.length];

        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        Stack<Integer> bucket = new Stack<>();

        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move - 1].pop();

                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }

    public int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
