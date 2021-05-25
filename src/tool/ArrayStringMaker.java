package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[-20,15], [-14,-5], [-18,-13], [-5,-3]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
