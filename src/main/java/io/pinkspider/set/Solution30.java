package io.pinkspider.set;

import java.util.ArrayList;

// 30. 간단한 유니온 파인드 알고리즘 구현하기
public class Solution30 {

    private static int[] parent;

    private static int findRootNode(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = findRootNode(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = findRootNode(x);
        int root2 = findRootNode(y);
        parent[root2] = root1;
    }

    public static Boolean[] solution(int k, int[][] operations) {

        parent = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operations) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            }
            else {
                answer.add(findRootNode(op[1]) == findRootNode(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }
}
