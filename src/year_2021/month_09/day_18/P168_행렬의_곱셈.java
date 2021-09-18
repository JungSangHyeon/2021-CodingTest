package year_2021.month_09.day_18;

public class P168_Çà·ÄÀÇ_°ö¼À {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){
                int val = 0;
                for(int k=0; k<arr1[0].length; k++){
                    val += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = val;
            }
        }

        return answer;
    }
}
