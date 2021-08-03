package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
