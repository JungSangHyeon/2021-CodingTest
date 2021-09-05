package year_2021.month_09.day_05;

public class P155_124³ª¶ó {

    public static void main(String[] args){
        for(int i=1; i<=10; i++){
            System.out.println(i+" : "+solution(i));
        }
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n/3!=0) {
            int mock = n/3;
            int namoji = n%3;

            if(namoji==0) {
                mock-=1;
                namoji=3;
            }
            n = mock;
            sb.append(namoji);
        }
        if(n%3!=0) sb.append(n%3);

        return sb.reverse().toString().replaceAll("3", "4");
    }
}
