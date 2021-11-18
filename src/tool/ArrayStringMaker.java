package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = " [[1,3],[2,6],[8,10],[15,18]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
