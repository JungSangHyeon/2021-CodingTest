package year_2021.month_06.day_25;

public class P62_콜라츠_추측 {

	public static void main(String[] args) {
		solution(626331);
	}

	
	public static int solution(int num) {
		if(num==1) return 0;
        long longNum = num;
		for(int i=0; i<500; i++) {
			if(longNum%2==0) longNum/=2;
			else longNum=longNum*3+1;
			
			if(longNum==1) return i+1;
		}
        return -1;
    }
}
