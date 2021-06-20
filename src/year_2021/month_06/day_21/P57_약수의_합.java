package year_2021.month_06.day_21;

public class P57_약수의_합 {

	public static void main(String[] args) {

	}

	private class A {
		
		public int solution(int n) {
			int answer = 0;
			return answer;
		}
		
		public int getSumOfDivisor(int targetNumber) {
			int sumOfDivisor = 0;
			for(int i=1; i<targetNumber; i++) {
				if(targetNumber%i==0) sumOfDivisor+=i;
			}
			return sumOfDivisor;
		}
	}
}
