package io.pinkspider.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 23. 신고 결과 받기
// HashSet 사용할 생각을 했어야 함.
public class Solution23 {

    public static int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedUserId = s[1];

            if (!reportedUser.containsKey(reportedUserId)) {
                reportedUser.put(reportedUserId, new HashSet<>());
            }
            reportedUser.get(reportedUserId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String userId : entry.getValue()) {
                    count.put(userId, count.getOrDefault(userId, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
