package year_2021.month_09.day_11;

import java.util.HashSet;
import java.util.StringTokenizer;

public class P161_프렌즈4블록 {

    public static void main(String[] args){
//        int a = solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
        int a = solution(7, 2, new String[]{"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"});
        System.out.println(a);
    }

    public static int solution(int m, int n, String[] board) { // 높이, 가로 [m][n]
        int removed = 0, nowRemoved;
        do{
            nowRemoved = remove4Block(m, n, board);
            removed += nowRemoved;
            down(m, n, board);
        }while(nowRemoved!=0);
        return removed;
    }

    private static int remove4Block(int m, int n, String[] board) {
        HashSet<String> points = new HashSet<>();
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                char now = board[i].charAt(j);
                char right = board[i].charAt(j+1);
                char down = board[i+1].charAt(j);
                char rightDown = board[i+1].charAt(j+1);
                if(now!='X' &&now == right && now == down && now == rightDown){
                    points.add(i+" "+j);
                    points.add((i+1)+" "+j);
                    points.add(i+" "+(j+1));
                    points.add((i+1)+" "+(j+1));
                }
            }
        }
        for(String point : points){
            StringTokenizer st = new StringTokenizer(point);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder(board[x]);
            sb.setCharAt(y, 'X');
            board[x] = sb.toString();
        }
        return points.size();
    }

    private static void down(int m, int n, String[] board) {
        for(int i=m-1; i>=0; i--){
            for(int j=0; j<n; j++){
                if(board[i].charAt(j)=='X'){
                    for(int k=i-1; k>=0; k--){
                        if(board[k].charAt(j)!='X'){
                            StringBuilder sb = new StringBuilder(board[i]);
                            sb.setCharAt(j, board[k].charAt(j));
                            board[i] = sb.toString();
                            sb = new StringBuilder(board[k]);
                            sb.setCharAt(j, 'X');
                            board[k] = sb.toString();
                            break;
                        }
                    }
                }
            }
        }
    }
}
