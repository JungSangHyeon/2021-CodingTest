package year_2021.month_07.day_21;

public class P91_입국심사 {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7,10}));
	}

	public static long solution(int n, int[] times) {
		long minCheckTime = Integer.MAX_VALUE;
		for(int i=0; i<times.length; i++) {
			if(minCheckTime > times[i]) minCheckTime = times[i];
		}
		
		long low=0, high=minCheckTime*n, mid=0, answer=0;
		while(low<=high) {
			mid = (low+high)/2;
			int checkedCount = 0;
			for(int i=0; i<times.length; i++) {
				checkedCount+= mid/times[i];
				if(checkedCount >= n) {
					answer = mid;
					high = mid-1;
					break;
				}
			}
			if(checkedCount < n) {low = mid+1;}
		}
        return answer;
    }
	
}
