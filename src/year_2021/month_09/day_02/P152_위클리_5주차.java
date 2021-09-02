package year_2021.month_09.day_02;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class P152_위클리_5주차 {

    static int count = 0, answer;

    public static void main(String[] args){
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        ArrayList<Character> symbols = new ArrayList<>();
        symbols.add('A');
        symbols.add('E');
        symbols.add('I');
        symbols.add('O');
        symbols.add('U');

        String wordByNum = "";
        for(char c : word.toCharArray()){
            wordByNum += symbols.indexOf(c);
        }
        num(wordByNum, "", 0);
        return answer;
    }

    public static void num(String target, String s, int depth){
        if(target.equals(s)) answer = count;
        count++;
        if(5==depth) return;
        for(int i=0; i<=4; i++) num(target, s+i, depth+1);
    }

}
