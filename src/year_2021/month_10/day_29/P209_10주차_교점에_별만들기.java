package year_2021.month_10.day_29;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P209_10주차_교점에_별만들기 {

    public static void main(String[] args) throws Exception {
    }
    public static int startX = Integer.MAX_VALUE, endX = Integer.MIN_VALUE;
    public static int startY = Integer.MAX_VALUE, endY = Integer.MIN_VALUE;

    public String[] solution(int[][] line) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<line.length-1; i++) {
            for(int j=i+1; j<line.length; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];
                long denominator = (a * d) - (b * c);
                if(denominator == 0) continue;

                long numerator1 = (b * f) - (e * d);
                long numerator2 = (e * c) - (a * f);
                if(numerator1 % denominator != 0 || numerator2 % denominator != 0) continue;

                int x  = (int) (numerator1 / denominator), y = (int) (numerator2 / denominator);
                list.add(Arrays.asList(x, y));

                startX = Math.min(startX, x);
                endX = Math.max(endX, x);
                startY = Math.min(startY, y);
                endY = Math.max(endY, y);
            }
        }

        String defaultLine = ".".repeat(endX - startX + 1);
        List<String> board = new ArrayList<>();
        for(int i=startY; i<=endY; i++) board.add(defaultLine);

        for(List<Integer> intersection : list) {
            StringBuilder sb = new StringBuilder(board.get(Math.abs(intersection.get(1) - endY)));
            sb.setCharAt(Math.abs(intersection.get(0) - startX), '*');
            board.set(Math.abs(intersection.get(1) - endY), sb.toString());
        }

        String[] answer = new String[board.size()];
        for(int i=0; i<answer.length; i++) answer[i] = board.get(i);

        return answer;
    }

}
