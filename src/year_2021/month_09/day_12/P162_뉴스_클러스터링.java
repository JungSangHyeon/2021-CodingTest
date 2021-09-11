package year_2021.month_09.day_12;

import year_2021.month_06.day_10.P45_키패드_누르기;

import java.util.ArrayList;
import java.util.Arrays;

public class P162_뉴스_클러스터링 {

    public static void main(String[] args){
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
    }

    public static int solution(String str1, String str2) {
        ArrayList<String> arr1 = get2WordList(str1.toUpperCase());
        ArrayList<String> arr2 = get2WordList(str2.toUpperCase());

        int intersectCount = getIntersectCount(arr1, arr2);
        int unionCount = arr1.size() + arr2.size();

        float jakad = (unionCount==0)? 1 : (float) intersectCount / unionCount;
        return (int) (jakad*65536);
    }

    private static ArrayList<String> get2WordList(String target){
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<target.length()-1; i++){
            char c1 = target.charAt(i);
            char c2 = target.charAt(i+1);
            if(('A' <= c1 && c1 <= 'Z') && ('A' <= c2 && c2 <= 'Z')){
                arr.add("" + target.charAt(i) + target.charAt(i+1));
            }
        }
        return arr;
    }
    private static int getIntersectCount(ArrayList<String> arr1, ArrayList<String> arr2) {
        int count = 0;
        for(String str : arr1){
            if(arr2.contains(str)){
                arr2.remove(str);
                count++;
            }
        }
        return count;
    }
}
