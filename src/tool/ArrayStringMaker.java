package tool;

public class ArrayStringMaker {

	public static void main(String[] args) {

		String target = "[[\"100\",\"ryan\",\"music\",\"2\"],[\"200\",\"apeach\",\"math\",\"2\"],[\"300\",\"tube\",\"computer\",\"3\"],[\"400\",\"con\",\"computer\",\"4\"],[\"500\",\"muzi\",\"music\",\"3\"],[\"600\",\"apeach\",\"music\",\"2\"]]";
		System.out.println(target.replace("[", "{").replace("]", "}"));
	}

}
