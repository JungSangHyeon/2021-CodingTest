package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
