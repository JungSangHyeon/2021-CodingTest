package year_2021.month_08.day_27;

import java.util.Arrays;
import java.util.StringTokenizer;

public class P146_위클리_4주차 {

    public String solution(String[] table, String[] languages, int[] preference) {
        String bestJob = "";
        int bestScore = 0;

        Arrays.sort(table);
        for(String record : table) {
            StringTokenizer st = new StringTokenizer(record);
            String jobName = st.nextToken();
            int score = 0;
            for(int i=5; i>=1; i--) {
                String languageName = st.nextToken();
                for(int j=0; j<languages.length; j++){
                    if(languageName.equals(languages[j])) score += i*preference[j];
                }
            }
            if(bestScore < score) {
                bestJob = jobName;
                bestScore = score;
            }
        }
        return bestJob;
    }

}
