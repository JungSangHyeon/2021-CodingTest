package year_2021.month_06.day_08;

public class P43_소수_만들기 {

	/**
	 */
	public static void main(String[] args) {
		new a2().solution(new int[] {1,2,3,4});
	}

	private static class a2 {
		
		private int sum = 0, count = 0;
		
		public int solution(int[] nums) {
			getCombination(nums, 0, 3, 0);
			return count;
		}
		
		public void getCombination (int[] nums, int startIndex, int max, int now) {
			if(max==now) { isSosu(sum); return; }
			for(int i=startIndex; i<nums.length; i++) {
				int tempSum = sum;
				sum+=nums[i];
				getCombination(nums, i+1, max, now+1);
				sum=tempSum;
			}
		}
		
		public void isSosu(int sum) {
			boolean result = true;
			for(int i=2; i<sum; i++) {
				if(sum%i==0) {result=false; break;}
			}
			if(result) count++;
		}
	}
}
