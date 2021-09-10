package year_2021.month_09.day_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P160_위클리_6주차 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"})));
    }
    public static int[] solution(int[] weights, String[] head2head) {
        ArrayList<Boxer> boxers = new ArrayList<>();
        for(int i=0; i<weights.length; i++){
            boxers.add(new Boxer(i, weights, head2head[i]));
        }

        boxers.sort((b1, b2) -> {
            if(b1.winRate != b2.winRate) return -Float.compare(b1.winRate, b2.winRate);
            else if(b1.winHeavy != b2.winHeavy) return -Integer.compare(b1.winHeavy, b2.winHeavy);
            else if(b1.weight != b2.weight) return -Integer.compare(b1.weight, b2.weight);
            else return Integer.compare(b1.num, b2.num);
        });

        int[] answer = new int[weights.length];
        for(int i=0; i< answer.length; i++){
            answer[i] = boxers.get(i).num;
        }
        return answer;
    }

    private static class Boxer {
        public int num, weight, winHeavy;
        public float winRate;

        public Boxer(int num, int[] weights, String history){
            this.num=num+1;
            this.weight=weights[num];

            float totalMatch = 0, totalWin = 0;
            this.winHeavy=0;
            for(int i=0; i<history.length(); i++){
                if(history.charAt(i)=='W') {
                    totalMatch++;
                    totalWin++;
                    if(this.weight < weights[i]){
                        this.winHeavy++;
                    }
                }else if(history.charAt(i)=='L') {
                    totalMatch++;
                }
            }
            if(totalMatch==0){
                this.winRate = 0;
            }else{
                this.winRate=totalWin/totalMatch;
            }
        }
    }
}
