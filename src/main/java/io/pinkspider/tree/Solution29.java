package io.pinkspider.tree;

import java.util.ArrayList;
import java.util.Arrays;

// 길 찾기 게임
public class Solution29 {

    private static class Node {

        int x, y, num;
        Node left, right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    private static Node makeBT(int[][] nodeInfo) {
        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            while (true) {
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        return nodes[0];
    }

    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public static int[][] solution(int[][] nodeInfo) {
        int[][] answer = new int[2][nodeInfo.length];

        Node root = makeBT(nodeInfo);
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrder(root, preOrder);

        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrder(root, postOrder);

        answer[0] = preOrder.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrder.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
