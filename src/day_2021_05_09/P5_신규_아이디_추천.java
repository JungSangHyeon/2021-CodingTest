package day_2021_05_09;

public class P5_�ű�_���̵�_��õ {

	/**
	 * ��� ��
	 * 1. String ���Խ�. �� ����ϸ� �ڵ带 ���� ���� �� �ְڴ�.
	 *  ����: https://codechacha.com/ko/java-regex/
	 *  
	 *  �ٸ� ��� �ڵ� ���� 456�� ����ǥ�������� �����ϴ�.
	      temp = temp.replaceAll("[.]{2,}","."); // ... ->.
          temp = temp.replaceAll("^[.]|[.]$",""); // ó�� �Ǵ� �������� . �̸� ����
          if(temp.length() >=16){
              temp = temp.substring(0,15);
              temp=temp.replaceAll("^[.]|[.]$","");
          }
	 */
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}

	public static String solution(String new_id) {
		new_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("[.]+", "."); // 1, 2, 3
		new_id = (new_id.length()>0 && new_id.charAt(0)=='.')? new_id.substring(1, new_id.length()):new_id; // 4
		new_id = (new_id.length()>0 && new_id.charAt(new_id.length()-1)=='.')? new_id.substring(0, new_id.length()-1):new_id; // 4
		new_id = (new_id.length()==0)? "a":new_id; // 5
		new_id = (new_id.length()>15)? new_id.substring(0, 15):new_id; // 6
		new_id = (new_id.charAt(new_id.length()-1)=='.')? new_id.substring(0, new_id.length()-1):new_id; // 6
		while(new_id.length()<3) {new_id+=new_id.charAt(new_id.length()-1);} // 7
        return new_id;
    }
}
