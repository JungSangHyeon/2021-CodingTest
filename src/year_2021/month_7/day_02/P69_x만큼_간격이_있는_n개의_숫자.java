package year_2021.month_7.day_02;

public class P69_x만큼_간격이_있는_n개의_숫자 {

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
