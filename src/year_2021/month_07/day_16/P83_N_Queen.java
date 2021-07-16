package year_2021.month_07.day_16;

public class P83_N_Queen {

	static int N;
	static int[] QueenPlacedX;
	static int placedQueenCount, possibleCaseCount;
	
	public int solution(int n) {
        N = n;
        QueenPlacedX = new int[N];
		placedQueenCount = possibleCaseCount = 0;
		
        getAnswer(0);
        
        return possibleCaseCount;
    }

	private static void getAnswer(int y) {
		if(placedQueenCount == N) { possibleCaseCount++; return; }
			
		for(int x=0; x<N; x++) {
			if(isQueenPlaceable(x, y)) {
				QueenPlacedX[y] = x;
				placedQueenCount++;
				getAnswer(y+1);
				QueenPlacedX[y] = 0;
				placedQueenCount--;
			}
		}
	}

	private static boolean isQueenPlaceable(int targetX, int targetY) {
		for(int y=0; y<placedQueenCount; y++) {
			boolean canKillHorizontally = QueenPlacedX[y]==targetX;
			boolean canKillDiagonally = Math.abs(QueenPlacedX[y]-targetX)==Math.abs(y-targetY);
			if(canKillHorizontally || canKillDiagonally) return false;
		}
		return true;
	}
}
