package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[0, 1, 1], [2, 3, 2], [4, 5, 2], [2, 4, 3], [1, 5, 4]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
