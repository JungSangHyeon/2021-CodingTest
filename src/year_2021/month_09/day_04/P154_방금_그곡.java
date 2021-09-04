package year_2021.month_09.day_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P154_¹æ±Ý_±×°î {

    public static void main(String[] args){
//        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
//        System.out.println(solution("CDEFGAC", new String[]{"12:00,12:07,HELLO,C#DEFGA"}));
    }

    public static String solution(String m, String[] musicinfos) {
        String m2 = "";
        for(int i=0; i<m.length(); i++){
            if(m.length() > i+1 && m.charAt(i+1)=='#') {
                m2 += m.charAt(i) + ('a'-'A');
                i++;
            }else{
                m2 += m.charAt(i);
            }
        }

        ArrayList<MusicInfo> infos = new ArrayList<>();
        for(String musicInfo : musicinfos) {
            infos.add(new MusicInfo(musicInfo));
        }

        ArrayList<MusicInfo> qualifiedInfos = new ArrayList<>();
        for(MusicInfo musicInfo : infos) {
            if(musicInfo.playedMelody.contains(m2)){
                qualifiedInfos.add(musicInfo);
            }
        }

        int maxPlayTime = -1;
        String title = "(None)";
        for(MusicInfo musicInfo : qualifiedInfos){
            if(musicInfo.playMinute > maxPlayTime){
                maxPlayTime = musicInfo.playMinute;
                title = musicInfo.title;
            }
        }
        return title;
    }

    private static class MusicInfo {
        public int playMinute;
        public String title, playedMelody;

        public MusicInfo(String musicInfo) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            int startHour = Integer.parseInt(startTime.split(":")[0]);
            int startMinute = Integer.parseInt(startTime.split(":")[1]);
            int endHour = Integer.parseInt(endTime.split(":")[0]);
            int endMinute = Integer.parseInt(endTime.split(":")[1]);
            this.playMinute = (endHour*60 + endMinute) - (startHour*60 + startMinute);
            this.title = st.nextToken();
            String melody = st.nextToken();
            this.playedMelody = "";
            int index = 0;
            for(int i=0; i<this.playMinute; i++){
                if(melody.length() > index+1 && melody.charAt(index+1)=='#') {
                    this.playedMelody += melody.charAt(index) + ('a'-'A');
                    index++;
                }else{
                    this.playedMelody += melody.charAt(index);
                }
                index++;
                if(index>=melody.length()) index=0;
            }
        }
    }


}
