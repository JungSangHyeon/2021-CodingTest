package year_2021.month_08.day_03;

public class P115_부족한_금액_계산하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long solution(int price, int money, int count) {
		long sum1ToCount = (1+count)*count/2;
		long totalPrice = price * sum1ToCount;
        boolean IslackOfMoney = money < totalPrice;
        
        if(IslackOfMoney) {
        	long lackMoney = totalPrice - money;
            return lackMoney;
        } else {
            return 0;
        }
    }
	
}
