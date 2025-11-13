package io.pinkspider.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

// 양과 늑대
public class Solution28 {

    /*
    - info 예 :
    int[] a = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};

    - edges 예 :
    int[][] b = {
        {0, 1},
        {1, 2},
        {1, 4},
        {0, 8},
        {8, 7},
        {9, 10},
        {9, 11},
        {4, 3},
        {6, 5},
        {4, 6},
        {8, 9}
    };
    */

    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    private static ArrayList<Integer>[] tree;

    private static void initTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public static int solution(int[] info, int[][] edges) {
        // info 에서 0은 양, 1은 늑대
        initTree(info, edges);
        int answer = 0;

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            answer = Math.max(answer, cur.sheep);
            cur.visited.addAll(tree[cur.node]);

            for (int next : cur.visited) {
                HashSet<Integer> set = new HashSet<>(cur.visited);
                set.remove(next);
                if (info[next] == 1) {
                    if (cur.sheep != cur.wolf + 1) {
                        queue.add(new Info(next, cur.sheep + 1, cur.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, cur.sheep + 1, cur.wolf, set));
                }
            }
        }

        return answer;
    }
}
