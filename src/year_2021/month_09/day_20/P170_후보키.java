package year_2021.month_09.day_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P170_ÈÄº¸Å° {

    public static void main(String[] args){
        System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }

    public static int solution(String[][] relation) {
        int columnNum = relation[0].length;
        ArrayList<String> arr1 = new ArrayList<>();
        for(int i=1; i<=columnNum; i++){
            nums.clear();
            getNum(0, columnNum-1, i, 0, "");
            HashSet<String> set = new HashSet<>();
            System.out.println(nums.toString());
            for(String num : nums){
                set.clear();
                for(int j=0; j< relation.length; j++){
                    String key = "";
                    StringTokenizer st = new StringTokenizer(num);
                    while(st.hasMoreTokens()){
                        key+=relation[j][Integer.parseInt(st.nextToken())];
                    }
                    set.add(key);
                }
                if(set.size()==relation.length){
                    arr1.add(num);
                }
            }
        }

        System.out.println(arr1.toString());

        ArrayList<String> arr2 = new ArrayList<>();
        while(arr1.size()!=0){
            String nowAdded = arr1.get(0);
            arr2.add(nowAdded);
            arr1.remove(0);

            for(int i=arr1.size()-1; i>=0; i--){
                String s = arr1.get(i);
                boolean remove = true;
                StringTokenizer st = new StringTokenizer(nowAdded);
                while(st.hasMoreTokens()){
                    if(!s.contains(st.nextToken())){
                        remove = false;
                    }
                }
                if(remove){
                    arr1.remove(i);
                }
            }
        }

        System.out.println(arr2.toString());

        return arr2.size();
    }

    static ArrayList<String> nums = new ArrayList<>();
    public static void getNum(int min, int max, int deep, int nowDeep, String num){
        for(int i=min; i<=max; i++){
            if(deep==nowDeep+1) nums.add(num+i+" ");
            getNum(i+1, max, deep, nowDeep+1, num+i+" ");
        }
    }
}
