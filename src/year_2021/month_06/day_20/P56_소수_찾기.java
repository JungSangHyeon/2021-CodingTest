package year_2021.month_06.day_20;

import java.util.Arrays;

public class P56_�Ҽ�_ã�� {

	/**
	 * Clean Code å�� ���� �а� ���� ���� ���Ҵ�. Ȯ���� ���ذ� ���� �� �ϴ�.
	 */
	
	public static void main(String[] args) {
	}
	
	private static class a {
		
		public int solution(int n) {
			return this.getPrimeCount(n);
	    }

		private int getPrimeCount(int limit) {
			boolean[] isPossiblePrimes = this.getIsPossiblePrimes(limit);
			int possibleMaxDivisor = limit/2;
			for(int i=0; i<=possibleMaxDivisor; i++) this.removeAllMultipleOfPrime(isPossiblePrimes, i, limit);
			return this.getTrueCount(isPossiblePrimes);
		}

		private boolean[] getIsPossiblePrimes(int n) {
			boolean[] isPossiblePrimes = new boolean[n+1]; // 0~n
			Arrays.fill(isPossiblePrimes, Boolean.TRUE);
			isPossiblePrimes[0] = isPossiblePrimes[1] = false; // prime precondition
			return isPossiblePrimes;
		}
		
		private void removeAllMultipleOfPrime(boolean[] isPossiblePrimes, int prime, int limit) {
			if(isPossiblePrimes[prime]) this.removeAllMultipleOfNumber(isPossiblePrimes, prime, limit);
		}
		
		private void removeAllMultipleOfNumber(boolean[] isPossiblePrimes, int number, int limit) {
			for(int i=number*2; i<=limit; i+=number) isPossiblePrimes[i] = false;
		}

		private int getTrueCount(boolean[] booleans) {
			int count = 0;
			for(boolean bool : booleans) if(bool) count++;
			return count;
		}
	}
	
	
}
