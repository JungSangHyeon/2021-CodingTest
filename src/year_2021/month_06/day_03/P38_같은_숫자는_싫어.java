package year_2021.month_06.day_03;

import java.util.ArrayList;


public class P38_����_���ڴ�_�Ⱦ� {

	/**
	 * ������� ���ƺ��� 
	 */
	public static void main(String[] args) {
	}

	public int[] solution(int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int before = -1;
		for(int i : arr) {
			if(before!=i) {
				answer.add(i);
				before = i;
			}
		}
		return answer.stream().mapToInt(Number::intValue).toArray();
	}
}
