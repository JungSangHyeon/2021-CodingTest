package year_2021.month_06.day_04;

public class P39_단체사진_찍기 {

	public static void main(String[] args) {
//		solution(2, new String[] {"M~C<2", "C~M>1"});
		solution(2, new String[] {"N~F=0", "R~T>2"});
	}

	// 1. 전체 가능성을 하나하나 보면서 합/불합을 따져본다.
	// 2. 조건에 따라 가능한 배치를 하나하나 따지기엔 너무 복잡하지...
	
	static int answer = 0;
	static String nowPermutation="";
	static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static boolean[] friendSeat = new boolean[8];
	static String[] conditions;
	
	public static int solution(int n, String[] data) {
		conditions=data;
		createPermutation(0);
        return answer;
    }

	public static void createPermutation(int now) {
		if(now==friends.length) { checkPermutation(); return; }
		for(int i=0; i<friends.length; i++) {
			if(!friendSeat[i]) {
				friendSeat[i]=true;
				nowPermutation+=friends[i];
				createPermutation(now+1);
				nowPermutation = nowPermutation.substring(0, nowPermutation.length()-1);
				friendSeat[i]=false;
			}
		}
	}
	
	public static void checkPermutation() {
		for(String condition : conditions) {
			int frend1Index = nowPermutation.indexOf(condition.charAt(0));
			int frend2Index = nowPermutation.indexOf(condition.charAt(2));
			int distance = Math.abs(frend1Index - frend2Index)-1;
			int wantDistance = condition.charAt(4)-'0';
			switch(condition.charAt(3)) {
			case '=': if(!(distance==wantDistance)) {return;} break;
			case '<': if(!(distance<wantDistance)) {return;} break;
			case '>': if(!(distance>wantDistance)) {return;} break;
			}
		}
		answer++;
	}

}
