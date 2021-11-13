package year_2021.month_11.day_13;

public class P224_n2배열자르기 {

    public static void main(String[] args){
        solution(3, 0, 8);
        System.out.println();
        solution(3, 2, 4);
    }

    public static int[] solution(int n, long left, long right) {
        int length = (int) (right - left + 1);
        int[] answer = new int[length];
        int index=0;
        for(long i = left; i<=right; i++){
            answer[index++] = (int) (Math.max(i/n, i%n)+1);
        }
        return answer;
    }

}
