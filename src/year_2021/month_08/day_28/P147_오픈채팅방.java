package year_2021.month_08.day_28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P147_오픈채팅방 {

    // Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
    // "Leave [유저 아이디]" (ex. "Leave uid1234")
    // "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")

    public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        ArrayList<AlarmMessage> alarmMessageArrayList = new ArrayList<>();

        for(String row : record) {
            StringTokenizer st = new StringTokenizer(row);
            String type = st.nextToken(), uid = st.nextToken(), name;

            if(type.equals("Enter")){
                name = st.nextToken();
                if(!nameMap.containsKey(uid)) nameMap.put(uid, name);
                else nameMap.replace(uid, name);
                alarmMessageArrayList.add(new AlarmMessage(type, uid));
            }else if(type.equals("Change")){
                name = st.nextToken();
                nameMap.replace(uid, name);
            }else if(type.equals("Leave")){
                alarmMessageArrayList.add(new AlarmMessage(type, uid));
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        for(AlarmMessage alarmMessage : alarmMessageArrayList) {
            String name = nameMap.get(alarmMessage.uid);
            String print = "";
            if(alarmMessage.type.equals("Enter")) print = name+"님이 들어왔습니다.";
            else if(alarmMessage.type.equals("Leave")) print = name+"님이 나갔습니다.";
            answer.add(print);
        }

        return answer.toArray(String[]::new);
    }

    private class AlarmMessage {
        String type, uid;

        public AlarmMessage(String type, String uid) {
            this.type=type;
            this.uid=uid;
        }
    }
}
