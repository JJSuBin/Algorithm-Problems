import java.util.Scanner;

class Stock_20546 {
	int money;
	int share;
	
	public Stock_20546(int money, int share) {
		this.money=money;
		this.share=share;
	}
	
	// 주식 구매 함수, 매개변수로 해당 날짜의 주가와 구매하려는 주식 수를 입력받는다.
	public void buyshare(int todaycost, int count) {
		// 현재 남은 금액보다 구매하려는 주식의 금액이 많다면 구매할 수 없다.
		if(this.money<todaycost*count)
			return;
		// 구매 가능한 경우 주식 수는 count 만큼 더해주고 주식 구매 금액은 현금에서 뺀다.
		this.share+=count;
		this.money-=todaycost*count;
	}
	
	// 모든 주식 매도 함수, 매개변수로 해당 날짜의 주가를 입력받는다.
	public void sellshare(int todaycost) {
		// 현재 주가에 모든 주식을 매도하기 때문에 해당 날짜의 주가에 현재 주식 수를 곱한 값을 현금에 더한다.
		this.money+=todaycost*this.share;
		this.share=0; // 모든 주식을 매도했으므로 현재 구매한 주식수는 0으로 초기화한다.
	}
}
public class BaekJoon_20546 {
	static int n;
	static int[] week=new int[14];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=0;i<14;i++)
			week[i]=sc.nextInt();
		
		int junhyun=BNP();
		int sungmin=Timing();
		
		if(junhyun>sungmin)
			System.out.println("BNP");
		else if(junhyun<sungmin)
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");
	}
	
	static int BNP() {
		Stock_20546 stock=new Stock_20546(n,0);
		
		// BNP 방법은 첫날부터 구매 가능한 모든 주식을 사는 것 
		for(int i=0;i<14;i++) {
			int cash=stock.money; // 현금
			int share=cash/week[i]; // 구매 가능한 주가 = 현금 / i일의 주가
			
			// 구매 가능한 주가가 양수일 경우는 구매 가능한 경우이기 때문에 해당 주식을 구매한다.
			if(share>0)
				stock.buyshare(week[i],share);
		}
		
		// 주식 주매 후 남은 잔액 + (14일의 주가 * 주식 수)
		int result=stock.money+(stock.share*week[13]);
		return result;
	}
	
	static int Timing() {
		Stock_20546 stock=new Stock_20546(n,0);
		
		for(int i=3;i<14;i++) {
			int cash=stock.money;
			int share=cash/week[i];
			
			// 주가가 3일 연속 상승한다면 해당 날짜 주가로 풀매도
			if(week[i-1]>week[i-2]&&week[i-2]>week[i-3])
				stock.sellshare(week[i]);
			
			// 주가가 3일 연속 하락한다면 해당 날짜 주가로 풀매수
			if(week[i-1]<week[i-2]&&week[i-2]<week[i-3])
				stock.buyshare(week[i],share);
		}
		
		// 주식 주매 후 남은 잔액 + (14일의 주가 * 주식 수)
		int result=stock.money+(stock.share*week[13]);
		return result;
	}
}
