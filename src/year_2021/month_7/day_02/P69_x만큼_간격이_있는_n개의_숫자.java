package year_2021.month_7.day_02;

public class P69_x��ŭ_������_�ִ�_n����_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long[] solution(int x, int n) {
		long longX = x;
        long[] answer = new long[n];
        for(int i=0; i<n; i++) answer[i]=longX+i*longX;
        return answer;
    }

}
