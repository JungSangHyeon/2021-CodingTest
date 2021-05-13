package year_2021.month_05.day_10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P10_���� {

	/**
	 * ��� ����
	 * 
	 * �̷��� ã�� �־��µ� �ֳ�
	 * IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();//�ε���
	 * return Arrays.stream(a).map(v -> v).sum(); // �̰� ���� ������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution2(new int[] {1,2,3,4}, new int[] {-3,-1,0,2}));
	}
	
	public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++){
            answer+=(a[i]*b[i]);
        }
        return answer;
    }

	public static int solution2(int[] a, int[] b) {
//		return Arrays.stream(a).map(v -> v).sum(); // �̰� ���� ������
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
	
}
