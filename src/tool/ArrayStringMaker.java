package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
