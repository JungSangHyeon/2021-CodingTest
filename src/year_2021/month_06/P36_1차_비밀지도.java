package year_2021.month_06;

public class P36_1차_비밀지도 {

	/**
	 * 배운 것
	 * 1. String.format으로 자리수 맞추는 법. 
	 */
	
	public static void main(String[] args) {
		System.out.println(String.format("%5s", Integer.toBinaryString(2)).replaceAll(" ", "0"));
	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			String s1 = String.format("%"+n+"s", Integer.toBinaryString(arr1[i])).replaceAll(" ", "0");
			String s2 = String.format("%"+n+"s", Integer.toBinaryString(arr2[i])).replaceAll(" ", "0");
			String s3 = "";
			for(int j=0; j<n; j++) {
				if(s1.charAt(j)=='1' || s2.charAt(j)=='1') s3+='#';
				else s3+=' '; 
			}
			answer[i]=s3;
		}
        return answer;
    }
}
