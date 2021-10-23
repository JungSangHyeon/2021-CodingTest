package year_2021.month_10.day_23;

public class P203_나머지가1이되는수찾기 {
    public int solution(int n) {
        int answer = 2;
        while(n%answer!=1) answer++;
        return answer;
    }
}
