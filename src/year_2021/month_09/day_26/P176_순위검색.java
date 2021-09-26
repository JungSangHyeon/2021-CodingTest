package year_2021.month_09.day_26;

import java.util.*;

public class P176_순위검색 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
        )));
    }

    public static int[] solution(String[] info, String[] query) {
        ArrayList<Info> infos = new ArrayList<>();
        for(String infoString : info) infos.add(new Info(infoString));
        infos.sort(Comparator.comparingInt(i -> i.score));

        Map<String, ArrayList<Integer>> map = getAllCaseMap();
        for(Info information : infos) information.addTo(map);

        ArrayList<Query> queries = new ArrayList<>();
        for(String queryString : query) queries.add(new Query(queryString));

        int[] answer = new int[queries.size()];
        for(int i=0; i<queries.size(); i++){
            Query q = queries.get(i);
            ArrayList<Integer> scoreList = map.get(q.getKey());
            int high = scoreList.size()-1, low = 0, mid = 0;
            while(low<=high){
                mid = (high+low)/2;
                if(q.score <= scoreList.get(mid)){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }

            answer[i] = scoreList.size()-low;
        }

        return answer;
    }

    private static Map<String, ArrayList<Integer>> getAllCaseMap() {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        String[] language = {"cpp", "java", "python", "-"};
        String[] part = {"backend", "frontend", "-"};
        String[] career = {"junior", "senior", "-"};
        String[] food = {"chicken", "pizza", "-"};
        for (String l : language) {
            for (String p : part) {
                for (String i : career) {
                    for (String f : food) {
                        map.put(l + p + i + f, new ArrayList<>());
                    }
                }
            }
        }
        return map;
    }

    private static class Info {
        public String language, part, career, food;
        public int score;

        public Info(String infoString){
            StringTokenizer st = new StringTokenizer(infoString);
            language = st.nextToken();
            part = st.nextToken();
            career = st.nextToken();
            food = st.nextToken();
            score = Integer.parseInt(st.nextToken());
        }

        public void addTo(Map<String, ArrayList<Integer>> map) {
            String[] language = {this.language, "-"};
            String[] part = {this.part, "-"};
            String[] career = {this.career, "-"};
            String[] food = {this.food, "-"};
            for (String l : language) {
                for (String p : part) {
                    for (String i : career) {
                        for (String f : food) {
                            map.get(l + p + i + f).add(score);
                        }
                    }
                }
            }
        }
    }

    private static class Query {
        public String language, part, career, food;
        public int score;

        public Query(String queryString){
            queryString = queryString.replaceAll("and", "");
            StringTokenizer st = new StringTokenizer(queryString);
            language = st.nextToken();
            part = st.nextToken();
            career = st.nextToken();
            food = st.nextToken();
            score = Integer.parseInt(st.nextToken());
        }
        public String getKey(){
            return language+part+career+food;
        }

        public boolean isSatisfy(Info info){
            boolean languageSatisfy = this.isSatisfyString(this.language, info.language);
            boolean partSatisfy = this.isSatisfyString(this.part, info.part);
            boolean careerSatisfy = this.isSatisfyString(this.career, info.career);
            boolean foodSatisfy = this.isSatisfyString(this.food, info.food);
            boolean scoreSatisfy = this.score <= info.score;
            return languageSatisfy && partSatisfy && careerSatisfy && foodSatisfy && scoreSatisfy;
        }
        private boolean isSatisfyString(String queryString, String infoString){
            return queryString.equals("-") || queryString.equals(infoString);
        }
    }
}
