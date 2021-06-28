package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
