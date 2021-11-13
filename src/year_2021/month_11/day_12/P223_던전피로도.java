package year_2021.month_11.day_12;

import java.util.Arrays;
import java.util.Comparator;

public class P223_던전피로도 {

    public static void main(String[] args){
        solution(	80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
    }

    static int maxDepth=0, depth=0, globalK;
    static int[][] globalDungeons;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {
        globalK=k;
        globalDungeons=dungeons;
        visited = new boolean[globalDungeons.length];
        travel();
        return maxDepth;
    }

    private static void travel() {
        for(int i=0; i<globalDungeons.length; i++){
            if(!visited[i] && globalK>=globalDungeons[i][0]){
                depth++;
                globalK-=globalDungeons[i][1];
                visited[i] = true;
                maxDepth = Math.max(maxDepth, depth);
                travel();
                depth--;
                globalK+=globalDungeons[i][1];
                visited[i] = false;
            }
        }
    }


}
