package year_2021.month_05.day_16;

import java.util.stream.IntStream;

public class P19_음양_더하기 {

	/**
	 * 나도 이제 한줄로 문제를 푸넹
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length).map(i-> absolutes[i]*(signs[i]? 1:-1)).sum();
    }
}
