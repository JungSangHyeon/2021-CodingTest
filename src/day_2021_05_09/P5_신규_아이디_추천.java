package day_2021_05_09;

public class P5_신규_아이디_추천 {

	/**
	 * 배운 것.
	 * 1. String 정규식. 잘 사용하면 코드를 많이 줄일 수 있겠다.
	 *  참고: https://codechacha.com/ko/java-regex/
	 *  
	 *  다른 사람 코드 보니 456도 정규표현식으로 가능하다.
	      temp = temp.replaceAll("[.]{2,}","."); // ... ->.
          temp = temp.replaceAll("^[.]|[.]$",""); // 처음 또는 마지막이 . 이면 제거
          if(temp.length() >=16){
              temp = temp.substring(0,15);
              temp=temp.replaceAll("^[.]|[.]$","");
          }
	 */
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}

	public static String solution(String new_id) {
		new_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("[.]+", "."); // 1, 2, 3
		new_id = (new_id.length()>0 && new_id.charAt(0)=='.')? new_id.substring(1, new_id.length()):new_id; // 4
		new_id = (new_id.length()>0 && new_id.charAt(new_id.length()-1)=='.')? new_id.substring(0, new_id.length()-1):new_id; // 4
		new_id = (new_id.length()==0)? "a":new_id; // 5
		new_id = (new_id.length()>15)? new_id.substring(0, 15):new_id; // 6
		new_id = (new_id.charAt(new_id.length()-1)=='.')? new_id.substring(0, new_id.length()-1):new_id; // 6
		while(new_id.length()<3) {new_id+=new_id.charAt(new_id.length()-1);} // 7
        return new_id;
    }
}
