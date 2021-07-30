package year_2021.month_07.day_30;

import java.util.ArrayList;

public class P106_수식_최대화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long solution(String expression) {
        ArrayList<String> myExpression = new ArrayList<>();
		String[] numberStrings = expression.split("[-|+|*]");
		String[] operators = expression.split("[0-9]+");
		for(int i=0; i<operators.length; i++) {
			myExpression.add(operators[i]);
			myExpression.add(numberStrings[i]);
		}
		myExpression.remove(0);
		
		long maxValue = 0;
		String[][] testCases = { { "*", "-", "+" }, { "*", "+", "-" }, { "-", "*", "+" }, { "-", "+", "*" }, { "+", "-", "*" }, { "+", "*", "-" }, };
		
		for(String[] testCase : testCases) {
			ArrayList<String> myExpressionCopy = (ArrayList<String>) myExpression.clone();
			for(String operator : testCase) {
				for(int i=0; i<myExpressionCopy.size(); i++) {
					if(myExpressionCopy.get(i).contentEquals(operator)) {
						long left = Long.parseLong(myExpressionCopy.get(i-1));
						long right = Long.parseLong(myExpressionCopy.get(i+1));
						long result = 0;
						switch(operator){
							case "*": result = left * right; break;
							case "+": result = left + right; break;
							case "-": result = left - right; break;
						}
						myExpressionCopy.set(i, Long.toString(result));
						myExpressionCopy.remove(i+1);
						myExpressionCopy.remove(i-1);
						i--;
					}
				}
			}
			long val = Math.abs(Long.parseLong(myExpressionCopy.get(0)));
			if(val > maxValue) maxValue = val;
		}
        return maxValue;
    }
}
