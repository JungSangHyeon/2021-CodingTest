package year_2021.month_06.day_14;

public class P49_���￡��_�輭��_ã�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String[] seoul) {
		int kimIndex = -1;
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals("Kim")) {kimIndex=i; break;}
		}
        return "�輭���� "+kimIndex+"�� �ִ�";
    }
}
