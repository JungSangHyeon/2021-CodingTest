package year_2021.month_07.day_25;

import java.util.ArrayList;

public class P99_Ä³½Ã {

	public static void main(String[] args) {
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
	}

	public static int solution(int cacheSize, String[] cities) {
		ArrayList<String> cache = new ArrayList<>();
		int useCacheSize = 0, time = 0;
		
		for(String city : cities) {
			city = city.toLowerCase();
			if(cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				time+=1;
			}else {
				cache.add(city);
				useCacheSize ++;
				time+=5;
			}
			
			if(useCacheSize > cacheSize) {
				cache.remove(0);
				useCacheSize --;
			}
		}
		
        return time;
    }
}
