package year_2021.month_07.day_22;

public class P95_땅따먹기 {

	// 와 10점 처음 받아봐! 이때까지 많이 줘봐야 7점인데
	// 핳하 그만큼 잘했다는 거지!
	
	public static void main(String[] args) {
		int[][] arr = new int[1000000][4];
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<4; j++) {
				arr[i][j]=100;
			}
		}
		System.out.println(solution(arr));
	}


	public static int[][] memory;
	
	static int solution(int[][] land) {
		memory = new int[land.length][4];
		for(int i=land.length-1; i>0; i--) search(land, i, -1);
		int answer = search(land, 0, -1);
        return answer;
    }
	
	public static int search(int[][] land, int depth, int beforeUseColum) {
		if(land.length == depth) return 0;
		int maxScore = -1;
		for(int i=0; i<4; i++) {
			if(i!=beforeUseColum) {
				int score = -1;
				if(memory[depth][i]!=0) {
					score = memory[depth][i];
				}else {
					score = search(land, depth+1, i)+land[depth][i];
					memory[depth][i] = score;
				}
				if(score>maxScore) maxScore = score;
			}
		}
		return maxScore;
	}
	
}
