package year_2021.month_05.day_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class P13_베스트앨범 {

	/**
	 * 너무 길다 싶었는데 뭐 나쁘지 않은 듯. 다들 나보다 한참 길게 썼넹
	 * 
	 * 배운 것
	 * ArrayList<Entry<String, Integer>> sortByPlayCount = new ArrayList<>(genreAndPlayCount.entrySet()); // 해쉬 셋을 리스트로!
	 */
	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, ArrayList<Song>> genreAndSong = new HashMap<>(); // Initialize Maps
		HashMap<String, Integer> genreAndPlayCount = new HashMap<>();
		for(int i=0; i< genres.length; i++) { 
			if(!genreAndSong.containsKey(genres[i])) {genreAndSong.put(genres[i], new ArrayList<>());}
			genreAndSong.get(genres[i]).add(new Song(i, plays[i]));
			genreAndPlayCount.put(genres[i], genreAndPlayCount.getOrDefault(genres[i], 0)+plays[i]);
		}
		for(String genre : genreAndSong.keySet()) { // Sort Songs By PlayCount
			Collections.sort(genreAndSong.get(genre), (o1, o2) -> {return -o1.playCount.compareTo(o2.playCount);} );
		}
		ArrayList<Entry<String, Integer>> sortGenreByPlayCount = new ArrayList<>(genreAndPlayCount.entrySet()); // Sort Genre By Total PlayCount 
		Collections.sort(sortGenreByPlayCount, (o1, o2) -> {return -o1.getValue().compareTo(o2.getValue());} );
		
		ArrayList<Integer> answerTemp = new ArrayList<>(); // Add Songs
		for(Entry<String, Integer> genre : sortGenreByPlayCount) { 
			answerTemp.add(genreAndSong.get(genre.getKey()).get(0).index);
			if(genreAndSong.get(genre.getKey()).size()>1) answerTemp.add(genreAndSong.get(genre.getKey()).get(1).index);
		}
		
		int[] answer = new int[answerTemp.size()]; // Convert To int[]
		for(int i=0; i<answer.length; i++) {answer[i] = answerTemp.get(i);}
        return answer;
    }
	private static class Song{
		public Integer index, playCount;
		public Song(Integer index, Integer playCount) {this.index=index; this.playCount=playCount;}
	}
}
