package year_2021.month_05.day_20;

public class P23_조이스틱 {

	/**
	 * Greedy가 그때그때 최적을 선택하는거구나.
	 * 나는 전부 봐야대서 그리딘줄 알았징
	 */
	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
		System.out.println(solution("ZZAAAZZ"));
	}

	public static int solution3(String name) {
		int changeCount = name.chars().map(c -> Math.min(Math.abs('A' - c), 26 - Math.abs('A' - c))).sum();
		int index = 0, move=0;
		while(name.replaceAll("A", "").length()!=0) {
			StringBuilder builder = new StringBuilder(name);
			builder.setCharAt(index, 'A');
			name = builder.toString();
			int frontIndex = index, backIndex = index, frontACount = -1, backACount = -1;
			do {
				frontACount++;
				frontIndex = (frontIndex+1 == name.length())? 0:frontIndex+1;
			}while(name.charAt(frontIndex)== 'A' && name.replaceAll("A", "").length()!=0);
			do {
				backACount++;
				backIndex = (backIndex-1 == -1)? name.length()-1:backIndex-1;
			}while(name.charAt(backIndex)== 'A' && name.replaceAll("A", "").length()!=0);
			index += (frontACount<=backACount)? 1:-1;
			if(index==-1) {index = name.length()-1;}
			if(index==name.length()) {index = 0;}
			move++;
		}
		return changeCount + move - 1;
	}
	
	// @@@@@@@@@@@@@@@@@@@@@
	
	public static int solution(String name) {
		int changeCount = name.chars().map(c -> Math.min(Math.abs('A' - c), 26 - Math.abs('A' - c))).sum();
		
		int index = 0, move=0;
		while(name.replaceAll("A", "").length()!=0) {
			StringBuilder builder = new StringBuilder(name);
			builder.setCharAt(index, 'A');
			name = builder.toString();
			System.out.println(name);
			builder.setCharAt(index, '^');
			System.out.println(builder.toString());
			System.out.println();
			
			int frontIndex = index, backIndex = index, frontACount = -1, backACount = -1;
			
			do {
				frontIndex = (frontIndex+1 == name.length())? 0:frontIndex+1;
				frontACount++;
			}while(name.charAt(frontIndex)== 'A' && name.replaceAll("A", "").length()!=0);
			
			do {
				backIndex = (backIndex-1 == -1)? name.length()-1:backIndex-1;
				backACount++;
			}while(name.charAt(backIndex)== 'A' && name.replaceAll("A", "").length()!=0);
			

			index += (frontACount<=backACount)? 1:-1;
			if(index==-1) { // -1 = length-1
				index = name.length()-1;
			}
			if(index==name.length()) { // length == 0 , length +1 = 1
				index = 0;
			}
			move++;
		}
		return changeCount + move - 1;
	}
	
	
	public static int solution2(String name) {
		int changeCount = name.chars().map(c -> Math.min(Math.abs('A' - c), 26 - Math.abs('A' - c))).sum();
		int frontACount = 0, backACount = 0;
		while (frontACount + 1 <= name.length() - 1 && name.charAt(frontACount + 1) == 'A') {frontACount++;}
		while (name.length() - 1 - backACount > 0 && name.charAt(name.length() - 1 - backACount) == 'A') {backACount++;}
		return changeCount + name.length() - Math.max(frontACount, backACount) - 1;
	}
	
	public static int solution1(String name) {
        int changeCount = name.chars().map(c->Math.min(Math.abs('A'-c), 26-Math.abs('A'-c))).sum();
		int frontACount = 0, backACount = 0;
		while(name.charAt(frontACount+1)=='A') {frontACount++;}
		while(name.charAt(name.length()-1-backACount)=='A') {backACount++;}
        return changeCount + name.length() - Math.max(frontACount, backACount) - 1;
    }
}
