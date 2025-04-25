package io.pinkspider;

import static io.pinkspider.array.Solution1to6.solution_05;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] answer = solution_05(arr1, arr2);
        System.out.println(Arrays.deepToString(answer));
    }
}
