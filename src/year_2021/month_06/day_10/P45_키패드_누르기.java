package year_2021.month_06.day_10;

public class P45_키패드_누르기 {

	public static void main(String[] args) {
		
		System.out.println("1234".indexOf(Integer.toString(4)));
	}

	public class A {
		
		private String leftPress = "147*", nearPress = "2580", rightPress = "369#";
		private String leftThumb = "*", rightThumb = "#";
		private String answer = "";
		
		public String solution(int[] numbers, String hand) {
			for(int number : numbers) {
				String charNumber = Integer.toString(number);
				if(this.leftPress.contains(charNumber)) this.leftHandPress(charNumber);
				else if(this.rightPress.contains(charNumber)) this.rightHandPress(charNumber);
				else if(this.nearPress.contains(charNumber)) {
					int leftDistance, rightDistance, indexOfNumber = this.nearPress.indexOf(charNumber);
					
					if(this.nearPress.contains(this.leftThumb)) leftDistance = Math.abs(this.nearPress.indexOf(this.leftThumb) - indexOfNumber);
					else leftDistance = Math.abs(this.leftPress.indexOf(this.leftThumb) - indexOfNumber) + 1;
					
					if(this.nearPress.contains(this.rightThumb)) rightDistance = Math.abs(this.nearPress.indexOf(this.rightThumb) - indexOfNumber);
					else rightDistance = Math.abs(this.rightPress.indexOf(this.rightThumb) - indexOfNumber) + 1;
					
					if(leftDistance>rightDistance) {this.rightHandPress(charNumber);}
					else if(leftDistance<rightDistance) {this.leftHandPress(charNumber);}
					else if(hand.equals("left")) {this.leftHandPress(charNumber);}
					else if(hand.equals("right")) {this.rightHandPress(charNumber);}
				}
			}
			return this.answer;
		}
		public void leftHandPress(String charNum) {this.answer+='L'; this.leftThumb=charNum;}
		public void rightHandPress(String charNum) {this.answer+='R'; this.rightThumb=charNum;}
	}
	

}
