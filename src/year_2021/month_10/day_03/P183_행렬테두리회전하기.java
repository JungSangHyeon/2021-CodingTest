package year_2021.month_10.day_03;

import java.util.Arrays;

public class P183_행렬테두리회전하기 {

    private int[][] grid;

    public static void main(String[] args){
        P183_행렬테두리회전하기 a = new P183_행렬테두리회전하기();
//        a.solution(100, 97, new int[][]{{1, 1, 100, 97}});
        a.solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        createGrid(rows, columns);
        int[] answer = new int[queries.length];
        for(int i=0; i< queries.length; i++){
            int[] query = queries[i];
            applyQuery(query);
            answer[i] = getMin(query);
            printGrid();
        }
        return answer;
    }

    private void printGrid() {
        for(int[] arr : grid){
            for(int i=0; i<arr.length; i++){
                System.out.print(String.format("%02d", arr[i])+", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void createGrid(int rows, int columns) {
        grid = new int[rows][columns];
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                grid[i][j] = num++;
            }
        }
    }

    private void applyQuery(int[] query) {
        int startColumn = query[0]-1, startRow = query[1]-1;
        int endColumn = query[2]-1, endRow = query[3]-1;
        int startPointValue = grid[startColumn][startRow];
        moveUp(startColumn+1, endColumn, startRow);
        moveRight(startRow+1, endRow, endColumn);
        moveDown(startColumn, endColumn-1, endRow);
        moveLeft(startRow+1, endRow-1, startColumn);
        grid[startColumn][startRow+1] = startPointValue;
    }
    private void moveUp(int startColumn, int endColumn, int row) {
        for(int i=startColumn; i<=endColumn; i++) grid[i-1][row] = grid[i][row];
    }
    private void moveRight(int startRow, int endRow, int column) {
        for(int i=startRow; i<=endRow; i++) grid[column][i-1] = grid[column][i];
    }
    private void moveDown(int startColumn, int endColumn, int row) {
        for(int i=endColumn; i>=startColumn; i--) grid[i+1][row] = grid[i][row];
    }
    private void moveLeft(int startRow, int endRow, int column) {
        for(int i=endRow; i>=startRow; i--) grid[column][i+1] = grid[column][i];
    }

    private int getMin(int[] query) {
        int startColumn = query[0]-1, startRow = query[1]-1;
        int endColumn = query[2]-1, endRow = query[3]-1;
        int min = grid[startColumn][startRow];
        for(int i=startColumn; i<=endColumn; i++){
            if(min > grid[i][startRow]) min = grid[i][startRow];
            if(min > grid[i][endRow]) min = grid[i][endRow];
        }
        for(int i=startRow; i<=endRow; i++){
            if(min > grid[startColumn][i]) min = grid[startColumn][i];
            if(min > grid[endColumn][i]) min = grid[endColumn][i];
        }
        return min;
    }

}
