package io.pinkspider;

import java.util.HashMap;
import java.util.HashSet;

// 방문길이
class Solution {

    private static HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;

        HashSet<String> answer = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[] move = location.get(dirs.charAt(i));
            int nx = x + move[0];
            int ny = y + move[1];

            if (!isValidMove(nx, ny)) {
                continue;
            }
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }

    private static boolean isValidMove(int nx, int ny) {
        return nx < 11 && nx >= 0 && ny < 11 && ny >= 0;
    }
}
