package io.pinkspider.hash;

import java.util.ArrayList;
import java.util.HashMap;

// 오픈 채팅방
public class Solution21 {

    public static String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();

        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", " 님이 들어왔습니다.");
        msg.put("Leave", " 님이 나갔습니다..");

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String action = record[i].split(" ")[0];
            String userId = record[i].split(" ")[1];
            String nickName = record[i].split(" ")[2];

            if (action.equals("Enter")) {
                map.put(userId, nickName);
            }

            if (action.equals("Leave")) {
                map.put(userId, nickName);
            }
        }


        for (int i = 0; i < record.length; i++) {
            String action = record[i].split(" ")[0];
            String userId = record[i].split(" ")[1];

            if(msg.containsKey(action)){
                answer.add(map.get(userId) + msg.get(action));
            }
        }

        return answer.toArray(new String[0]);
    }


    // 다른 이 풀이
    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";

    private HashMap<String, UserInfo> userMap = new HashMap<>();

    private class UserInfo {
        public String userId;
        public String nickName;

        public UserInfo(String userId, String nickName) {
            this.userId = userId;
            this.nickName = nickName;
        }

    }

    private class Command {
        public char command;
        public String userId;

        public Command(char command, String userName) {
            this.command = command;
            this.userId = userName;
        }
    }

    public String[] Other_solution(String[] records) {
        ArrayList<Command> commandList = new ArrayList<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String userId = split[1];
            String nickName = null;

            switch(command.charAt(0)) {
                case 'E': // Enter
                    nickName = split[2];
                    if(userMap.containsKey(userId) == false) {
                        userMap.put(userId, new UserInfo(userId, nickName));
                    } else {
                        userMap.get(userId).nickName = nickName;
                    }

                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'L': // Leave
                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'C': // Change
                    nickName = split[2];
                    userMap.get(userId).nickName = nickName;
                    break;
            }
        }

        return commandList.stream()
            .map(cmd -> String.format( cmd.command == 'E' ? ENTER_FORMAT : LEAVE_FORMAT , userMap.get(cmd.userId).nickName))
            .toArray(ary -> new String[commandList.size()]);
    }
}
