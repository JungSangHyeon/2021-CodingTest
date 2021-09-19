package year_2021.month_09.day_19;

import java.util.*;

public class P169_카카오_컬러링북 {

    public int[] solution(int m, int n, int[][] picture) {
        ArrayList<ArrayList<Area>> areaGroups = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Area nowArea = new Area(i, j, picture[i][j]);
                if(nowArea.color != 0){
                    boolean added = false;
                    for(ArrayList<Area> areaGroup : areaGroups){// add area in group
                        boolean isSameAreaGroup = false;
                        for(Area area : areaGroup){
                            isSameAreaGroup = area.isSameAreaGroup(nowArea);
                            if(isSameAreaGroup) break;
                        }
                        if(isSameAreaGroup){
                            areaGroup.add(nowArea);
                            added = true;
                            break;
                        }
                    }

                    if(!added){ // create new group
                        ArrayList<Area> newAreaGroup = new ArrayList<>();
                        newAreaGroup.add(nowArea);
                        areaGroups.add(newAreaGroup);
                    }
                }
            }
        }

        ArrayList<ArrayList<Area>> finalAreaGroups = new ArrayList<>();

        int index = -1;
        while(areaGroups.size()!=0){
            finalAreaGroups.add(areaGroups.get(0));
            areaGroups.remove(0);
            index++;

            boolean added = true;
            while(added){
                added = false;

                ArrayList<Area> mergeTarget = null;
                for(ArrayList<Area> areaGroup : areaGroups){
                    if(isSameAreaGroup(areaGroup, finalAreaGroups.get(index))){
                        mergeTarget = areaGroup;
                        added = true;
                        break;
                    }
                }

                if(added){
                    finalAreaGroups.get(index).addAll(mergeTarget);
                    areaGroups.remove(mergeTarget);
                }
            }
        }


        int numberOfAreaGroup = finalAreaGroups.size();
        int maxSizeOfOneAreaGroup = 0;
        for(ArrayList<Area> areaGroup : finalAreaGroups){
            if(maxSizeOfOneAreaGroup < areaGroup.size()){
                maxSizeOfOneAreaGroup = areaGroup.size();
            }
        }

        return new int[]{numberOfAreaGroup, maxSizeOfOneAreaGroup};
    }

    public boolean isSameAreaGroup(ArrayList<Area> group1, ArrayList<Area> group2){
        for(Area areaFromGroup1 : group1){
            for(Area areaFromGroup2 : group2){
                if(areaFromGroup1.isSameAreaGroup(areaFromGroup2)){
                    return true;
                }
            }
        }
        return false;
    }


    private class Area {
        public int x, y, color;

        public Area(int x, int y, int color){
            this.x=x;
            this.y=y;
            this.color=color;
        }

        public boolean isSameAreaGroup(Area other){
            boolean isSameColor = this.color==other.color;
            boolean isNear = (Math.abs(this.x - other.x) + Math.abs(this.y - other.y))==1;
            return isSameColor && isNear;
        }
    }
}
