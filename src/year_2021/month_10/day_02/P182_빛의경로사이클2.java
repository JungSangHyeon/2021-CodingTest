package year_2021.month_10.day_02;

import java.util.ArrayList;

public class P182_빛의경로사이클2 {

    private char[][] charGrid;
    private ArrayList<Integer> answer;
    private int count;
    private boolean[][][] checked;

    public int[] solution(String[] grid) {
        // Create Char Grid
        charGrid = new char[grid.length][grid[0].length()];
        for(int i=0; i< grid.length; i++){
            String row = grid[i];
            for(int j=0; j<grid[0].length(); j++){
                charGrid[i][j] = row.charAt(j);
            }
        }

        // Travel All Case
        answer = new ArrayList<>();
        checked = new boolean[grid.length][grid[0].length()][4];
        for(int y=0; y< grid.length; y++){
            for(int x=0; x<grid[0].length(); x++){
                for(int dir=0; dir<4; dir++){
                    if(!checked[y][x][dir]){
                        count = 0;
                        int myY = y, myX = x, myDir = dir;
                        while(!checked[myY][myX][myDir]){
                            checked[myY][myX][myDir] = true;
                            count++;

                            switch(myDir){
                                case 0: myY--; break;
                                case 1: myX++; break;
                                case 2: myY++; break;
                                case 3: myX--; break;
                            }
                            if(myY == -1) myY = charGrid.length-1;
                            if(myY == charGrid.length) myY = 0;
                            if(myX == -1) myX = charGrid[0].length-1;
                            if(myX == charGrid[0].length) myX = 0;

                            char charDir = charGrid[myY][myX];
                            switch(charDir){
                                case 'S': myDir = myDir; break;
                                case 'L': myDir = (myDir-1 == -1)? 3 : myDir-1; break;
                                case 'R': myDir = (myDir+1 == 4)? 0 : myDir+1; break;
                            }
                        }
                        answer.add(count);
                    }
                }
            }
        }

        // Return Result
        answer.sort(Integer::compareTo);
        return answer.stream().mapToInt(i -> i).toArray();
    }

}
