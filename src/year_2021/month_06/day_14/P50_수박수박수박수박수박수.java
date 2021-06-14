package year_2021.month_06.day_14;

public class P50_수박수박수박수박수박수 {

	public static void main(String[] args) {

	}

	public String solution(int n) {
		String answer = "";
		for(int i=0; i<n; i++) {
			if(i%2==0) answer+="수";
			else answer+="박";
		}
        return answer;
    }
}
