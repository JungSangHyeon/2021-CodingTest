package year_2021.month_06.day_23;

public class P60_Å¸°Ù_³Ñ¹ö {

	public static void main(String[] args) {
		A a = new A();
		int answer = a.solution(new int[] {1, 1, 1, 1, 1}, 3);
		System.out.println(answer);
	}

	private static class A {
		
		private int[] numbers;
		private int target, count;
		
		public int solution(int[] numbers, int target) {
			this.numbers=numbers;
			this.target=target;
			this.check(0, 0);
			return this.count;
		}
		
		public void check(int index, int sum) {
			if(index==this.numbers.length) {
				if(sum==this.target) this.count ++;
			}else {
				this.check(index+1, sum+this.numbers[index]);
				this.check(index+1, sum-this.numbers[index]);
			}
		}
		
		
	}
	
}
