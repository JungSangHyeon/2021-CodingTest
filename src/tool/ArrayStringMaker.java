package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
