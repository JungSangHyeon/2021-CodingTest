package year_2021.month_06.day_29;

import java.util.Arrays;

public class P66_Á¤¼ö_»ï°¢Çü {

	public static void main(String[] args) {
		A a = new A();
		int result = a.solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } });
		System.out.println(result);
	}

	private static class A {

		int[][] triangle, cash;

		public int solution(int[][] triangle) {
			this.triangle = triangle;
			this.cash = new int[this.triangle.length][this.triangle[this.triangle.length-1].length];
			for(int i = 0; i < this.cash.length; i++) Arrays.fill(this.cash[i], -1);
			return this.getMaxSum(0, 0);
		}

		private int getMaxSum(int i, int j) {
			if (i == triangle.length - 1) {
				return this.triangle[i][j];
			} else {
				if(this.cash[i][j]!=-1) return this.cash[i][j];
				this.cash[i][j] = this.triangle[i][j] + Math.max(this.getMaxSum(i + 1, j), this.getMaxSum(i + 1, j + 1)); 
				return this.cash[i][j];
			}
		}
	}

}
