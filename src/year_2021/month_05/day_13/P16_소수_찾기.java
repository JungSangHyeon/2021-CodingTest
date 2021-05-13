package year_2021.month_05.day_13;

import java.util.Arrays;
import java.util.HashSet;

public class P16_소수_찾기 {

	/**
	 * 감기에 걸려 쉬고싶기 때문에 깊게 생각하지 않고 한 문제만...
	 * 어지러워~
	 */
	public static void main(String[] args) {
		solution("011");
	}

	private static HashSet<Integer> permutations = new HashSet<>();
	
	public static int solution(String numbers) {
		for(int i=1; i<=numbers.length(); i++) {
			perm(numbers, new char[i], new boolean[numbers.length()], 0, numbers.length(), i);
		}
		return permutations.size();
	}
	
	private static void perm(String arr, char[] output, boolean[] visited, int depth, int n, int r) {
	    if (depth == r) {
	    	int outputInt = Integer.valueOf(Arrays.toString(output).replaceAll("[^0-9]", ""));
	    	if(isSosu(outputInt)) permutations.add(outputInt);
	        return;
	    }
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = arr.charAt(i);
	            perm(arr, output, visited, depth + 1, n, r);       
	            visited[i] = false;
	        }
	    }
	}
	private static boolean isSosu(int target) {
		if(target==0 || target==1) return false;
		if(target== 2) return true;
		for(int i=2; i<target; i++) { if(target%i==0) return false; }
		return true;
	}
}
