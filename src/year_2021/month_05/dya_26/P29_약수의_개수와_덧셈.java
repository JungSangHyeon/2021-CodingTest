package year_2021.month_05.dya_26;

public class P29_�����_������_���� {

	/**
	 * �� UI ���� �Ϸ縸�� �����ؾߵ�! �׷��� ������ Ǯ�����. 
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(13, 17));
	}

	public static int solution(int left, int right) {
		int sum = 0;
		for(int i=left; i<right+1; i++) {
			int count = 0;
			for(int j=1; j<i+1; j++) {
				if(i%j==0) count++;
			}
			if(count%2==0) sum+=i;
			else sum-=i;
		}
		return sum;
	}
}
