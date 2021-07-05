package year_2021.month_07.day_04;

public class P71_Çà·ÄÀÇ_µ¡¼À {

	public static void main(String[] args) {

	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int arrayWidth = arr1.length;
		int arrayHeight = arr1[0].length;
        int[][] answer = new int[arrayWidth][arrayHeight];
        
        for(int i=0; i<arrayWidth; i++) {
        	for(int j=0; j<arrayHeight; j++) {
        		answer[i][j] = arr1[i][j]+arr2[i][j];
        	}
        }
        
        return answer;
    }
	
}
