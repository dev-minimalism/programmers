package io.pinkspider.tree;

// 예상 대진표
public class Solution26 {

    public static int solution(int N, int A, int B) {
        int answer;

        for (answer = 0; A != B; answer++) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
        }

        return answer;
    }
}
