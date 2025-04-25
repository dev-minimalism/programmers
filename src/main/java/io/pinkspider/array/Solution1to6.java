package io.pinkspider.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution1to6 {


    // 두 개 뽑아서 더하기
    public static int[] solution_03(int[] numbers) {
        TreeSet<Integer> result = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    // 수포자
    public static int[] solution_04(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            scores[0] += answers[i] == pattern1[i % pattern1.length % pattern1.length] ? 1 : 0;
            scores[1] += answers[i] == pattern2[i % pattern2.length % pattern2.length] ? 1 : 0;
            scores[2] += answers[i] == pattern3[i % pattern3.length % pattern3.length] ? 1 : 0;
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution_04_1(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            scores[0] += answers[i] == pattern1[i % pattern1.length % pattern1.length] ? 1 : 0;
            scores[1] += answers[i] == pattern2[i % pattern2.length % pattern2.length] ? 1 : 0;
            scores[2] += answers[i] == pattern3[i % pattern3.length % pattern3.length] ? 1 : 0;
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 행렬의 곱셈
    public static int[][] solution_05(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    // 06 실패율
    public static int[] solution_06(int N, int[] stages) {

        int[] challenger = new int[N + 2];
        Arrays.stream(stages).forEach(stage -> challenger[stage]++);

        HashMap<Integer, Double> fails = new HashMap<>();
        double totalPlayer = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, (double) challenger[i] / totalPlayer);
                totalPlayer -= challenger[i];
            }
        }

        return fails.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey).toArray();
    }
}
