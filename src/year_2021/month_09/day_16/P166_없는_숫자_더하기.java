package year_2021.month_09.day_16;

public class P166_없는_숫자_더하기 {

    public int solution(int[] numbers) { // 이게 왜 2렙이지?
        int sum = 45;
        for(int i=0; i<numbers.length; i++){
            sum -= numbers[i];
        }
        return sum;
    }
}
