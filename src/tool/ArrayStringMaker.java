package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[24, 10], [28, 39], [43, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
