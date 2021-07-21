package year_2021.month_07.day_21;

import java.util.Arrays;
import java.util.HashSet;

public class P92_영어_끝말잇기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, new String[]{
				"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
//				"hello", "one", "even", "never", "now", "world", "draw"
		})));
	}

	public static int[] solution(int n, String[] words) {
		HashSet<String> set = new HashSet<>();
		String lastWord=words[0];
		set.add(lastWord);
		int wrongIndex = -1;
		
		for(int i=1; i<words.length; i++) {
			boolean startNotEqualEnd = lastWord.charAt(lastWord.length()-1)!=words[i].charAt(0);
			boolean alreadyUsed = set.contains(words[i]);
			if(startNotEqualEnd || alreadyUsed) {
				wrongIndex = i;
				break;
			} else {
				lastWord = words[i];
				set.add(lastWord);
			}
		}
		
		wrongIndex++;
		if(wrongIndex==0) {
			return new int[] {0, 0};
		} else {
			int wrongManNumber = (wrongIndex%n==0)? n : wrongIndex%n;
			int wrongManTurn = wrongIndex/n + ((wrongIndex%n==0)? 0:1);
			return new int[] {wrongManNumber, wrongManTurn};
		}
	}
}
