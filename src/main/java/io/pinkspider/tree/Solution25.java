package io.pinkspider.tree;

public class Solution25 {

    public static String[] solution(int[] input) {
        String[] result = new String[3];

        result[0] = preorder(input, 0).trim();
        result[1] = inorder(input, 0).trim();
        result[2] = postorder(input, 0).trim();

        return result;
    }

    private static String preorder(int[] input, int index) {
        if (index >= input.length) {
            return "";
        }

        return input[index] + " "
            + preorder(input, index + 1)
            + preorder(input, index + 2);
    }

    private static String inorder(int[] input, int index) {
        if (index >= input.length) {
            return "";
        }

        return inorder(input, 2 * index + 1)
            + input[index] + " "
            + inorder(input, 2 * index + 2);
    }

    private static String postorder(int[] input, int index) {
        if (index >= input.length) {
            return "";
        }

        return postorder(input, 2 * index + 1)
            + postorder(input, 2 * index + 2)
            + input[index] + " ";
    }
}
