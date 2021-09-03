package year_2021.month_09.day_03;

public class P153_문자열_압축 { // 2:00 ~ 2:13


    public static void main(String[] args){
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int minLength = s.length();
        for(int i=1; i<=s.length()/2; i++){
            String compressedString = "";
            String temp = s.substring(0, i);
            int count = 0;
            for(int j=0; j<s.length()-s.length()%i; j+=i){
                String now = s.substring(j, j+i);
                if(temp.equals(now)) {
                    count++;
                }else{
                    if(count==1) compressedString += temp;
                    else compressedString += count+temp;
                    temp = now;
                    count = 1;
                }
            }
            if(count==1) compressedString += temp;
            else compressedString += count+temp;
            if(s.length()%i != 0) compressedString += s.substring(s.length() - s.length()%i);
            if(minLength > compressedString.length()) minLength = compressedString.length();
        }
        return minLength;
    }

}
