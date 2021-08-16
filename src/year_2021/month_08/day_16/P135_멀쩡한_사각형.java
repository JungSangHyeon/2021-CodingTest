package year_2021.month_08.day_16;

import java.util.HashSet;

public class P135_멀쩡한_사각형 {

    public static void main(String[] args) {
        System.out.println(solution(100000000,100000000));
    }

    public static long solution(int w, int h) {
        double gradient = (double)h/w;
        long count = 0;
        for(int x=0; x<w; x++){
            count += Math.ceil(gradient*(x+1))-Math.floor(gradient*x);

        }
        System.out.println(count);
        long allSquare = w*h;
        System.out.println(allSquare);
        return w*h-count;
    }
}
