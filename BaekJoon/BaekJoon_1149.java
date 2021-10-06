import java.util.Scanner;

public class BaekJoon_1149 {
	static int[][] cost; // 입력받은 비용을 저장하는 함수
	static Integer[][] dp; // 탐색하면서 누적합을 저장할 함수
	static final int Red=0,Green=1,Blue=2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		cost=new int[n][3];
		dp=new Integer[n][3];
		
		for(int i=0;i<n;i++) {
			cost[i][Red]=sc.nextInt(); 
			cost[i][Green]=sc.nextInt();
			cost[i][Blue]=sc.nextInt();
		}
		
		// 첫 번째 값은 각 색상 비용의 첫 번쨰 값으로 초기화
		dp[0][Red]=cost[0][0];
		dp[0][Green]=cost[0][1];
		dp[0][Blue]=cost[0][2];
		
		System.out.println(Math.min(paint_house(n- 1, Red), Math.min(paint_house(n - 1, Green), paint_house(n - 1, Blue))));
	}
	
	/*
	 * dp[n][color]에는 각 n에 대해 빨/파/초로 색칠했을 때 가장 작은 값이 저장되어 있다.
	 * 이때 dp[n][color]의 값을 구하기 위해서는 해당 색을 제외한 나머지 두 색 중에 비용이 더 적은 값에 해당 색을 더해주면 된다. 
	 * 이때 나머지 색들 중 비용이 더 적은 값을 구하기 위해서는 이전 집들을 색칠해 해당 n까지 도달한 값을 더해줘야 하기 때문에 재귀 호출을 사용하여 구해준다.
	 */
	public static int paint_house(int n, int color) {
		//해당 배열의 값을 탐색하지 않았다면 color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
		if(dp[n][color]==null) {
			if(color==Red) 
				dp[n][Red]=Math.min(paint_house(n-1,Blue), paint_house(n-1,Green))+cost[n][Red];
			else if(color==Green) 
				dp[n][Green]=Math.min(paint_house(n-1,Blue), paint_house(n-1,Red))+cost[n][Green];
			else 
				dp[n][Blue]=Math.min(paint_house(n-1,Red), paint_house(n-1,Green))+cost[n][Blue];
		}
		return dp[n][color];
	}
}
