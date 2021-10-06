import java.util.*;

public class BaekJoon_9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int n=sc.nextInt();
			int[][] sticker=new int[2][n+1];
			int[][] dp=new int[2][n+1];
			
			for(int i=0;i<2;i++)
				for(int j=1;j<=n;j++)
					sticker[i][j]=sc.nextInt();
			
			/*
			 * 해당 문제는 0행의 첫 번째 스티커를 선택하는 경우와 
			 * 1행의 첫 번째 스티커를 선택하는  두 가지의 경우로 나뉜다.
			 * 따라서 dp의 각 행의 첫 번째 열 값을 입력받은 값으로 초기화 한다. 
			 */
			dp[0][1]=sticker[0][1];
			dp[1][1]=sticker[1][1];
			
			/*
			 * 특정 i번째 dp 값을 채우기 위해서는 한칸, 또는 두칸 뒤의 대각선을 고려해야 한다. 
			 * 두 칸 뒤의 대각선까지만 고려하는 이유는 세 칸 뒤의 대각선은 i번째 값 이전에
			 * 다른 칸의 값을 거친 후 도착할 수 있기 때문이다. 
			 * 문제는 최댓값을 구하는 것이기 때문에 다른 값을 거쳐 올 수 있는 세칸 뒤의 대각선을 고려대상이 아니다. 
			 */
			for(int i=2;i<=n;i++) {
				dp[0][i]=Math.max(dp[1][i-1],dp[1][i-2])+sticker[0][i];
				dp[1][i]=Math.max(dp[0][i-1],dp[0][i-2])+sticker[1][i];
			}
			
			System.out.println(Math.max(dp[0][n],dp[1][n]));
		}
	}

}
