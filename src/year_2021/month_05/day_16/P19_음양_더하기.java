package year_2021.month_05.day_16;

import java.util.stream.IntStream;

public class P19_����_���ϱ� {

	/**
	 * ���� ���� ���ٷ� ������ Ǫ��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length).map(i-> absolutes[i]*(signs[i]? 1:-1)).sum();
    }
}
