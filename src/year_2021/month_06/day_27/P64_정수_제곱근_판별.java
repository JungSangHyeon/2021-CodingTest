package year_2021.month_06.day_27;

public class P64_����_������_�Ǻ� {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

	public static long solution(long n) {
		for(long i=0; i<=n; i++) {
			if(i*i==n) return (i+1)*(i+1);
		}
        return -1;
    }
}
