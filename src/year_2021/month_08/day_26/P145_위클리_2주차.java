package year_2021.month_08.day_26;

public class P145_위클리_2주차 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(int[][] scores) {
		String answer = "";
		for(int i=0; i<scores.length; i++) {
			int selfScore = scores[i][i], sameScoreCount = 0, sum = 0;
			boolean notMin = false, notMax = false;
			for(int j=0; j<scores.length; j++) {
				sum+=scores[j][i];
				if(j!=i) {
					if(selfScore==scores[j][i]) sameScoreCount++;
					else if(selfScore < scores[j][i]) notMax = true;
					else if(selfScore > scores[j][i]) notMin = true;
				}
			}
			int average;
			if((!notMin || !notMax) && sameScoreCount == 0) average = (sum-selfScore) / (scores.length-1);
			else average = sum / scores.length;
			
			if(average >= 90) answer+="A";
			else if(average >= 80) answer+="B";
			else if(average >= 70) answer+="C";
			else if(average >= 50) answer+="D";
			else answer+="F";
		}
        return answer;
    }
}
