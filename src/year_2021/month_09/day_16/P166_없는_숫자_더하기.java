package year_2021.month_09.day_16;

public class P166_����_����_���ϱ� {

    public int solution(int[] numbers) { // �̰� �� 2������?
        int sum = 45;
        for(int i=0; i<numbers.length; i++){
            sum -= numbers[i];
        }
        return sum;
    }
}
