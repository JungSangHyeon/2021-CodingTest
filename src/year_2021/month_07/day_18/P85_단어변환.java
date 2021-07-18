package year_2021.month_07.day_18;

import java.util.ArrayList;
import java.util.Arrays;

public class P85_단어변환 {

	public static void main (String[] args){
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
	}

	public static int solution(String begin, String target, String[] words) {

		// Initialize
		boolean[] isVisited = new boolean[words.length];
		Arrays.fill(isVisited, false);
		
		ArrayList<String> connectWords = new ArrayList<>();
		connectWords.add(begin);
		
		// BFS
		int deep = 0;
		while(connectWords.size()!=0) {
			ArrayList<String> temp = new ArrayList<>();
			temp.addAll(connectWords);
			connectWords.clear();
			deep++;
			
			for(int i=0; i<temp.size(); i++) {
				for(int j=0; j<words.length; j++) {
					if(!isVisited[j] && isConnected(temp.get(i), words[j])) {
						isVisited[j] = true;
						connectWords.add(words[j]);
					}
				}
			}
			
			if(connectWords.contains(target)) return deep;
		}
		
        return 0;
    }
	
	private static boolean isConnected(String s1, String s2) {
		int diffCount = 0;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i)!=s2.charAt(i)) diffCount++;
		}
		return diffCount==1;
	}
	
}

















