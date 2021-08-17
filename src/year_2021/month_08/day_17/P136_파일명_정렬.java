package year_2021.month_08.day_17;

import java.util.Arrays;

public class P136_파일명_정렬 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[]{
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        })));
    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            String s1Header = getHeader(s1);
            String s2Header = getHeader(s2);
            int headerCompare = s1Header.compareTo(s2Header);
            if(headerCompare!=0) return headerCompare;
            else{
                int s1Number = getNumber(s1, s1Header);
                int s2Number = getNumber(s2, s2Header);
                return Integer.compare(s1Number, s2Number);
            }
        });
        return files;
    }

    private static String getHeader(String fileName) {
        return fileName.split("[0-9]")[0].toLowerCase();
    }
    private static int getNumber(String fileName, String header) {
        String headlessFileName = fileName.substring(header.length());
        return Integer.parseInt(headlessFileName.split("[^0-9]")[0]);
    }
}
