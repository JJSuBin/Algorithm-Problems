import java.io.*;

public class BaekJoon_17626 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] dp=new int[n+1];
		
		dp[0]=0;
		dp[1]=1;
		
		/*
		 * dp[1] = 1
		 * dp[2] = dp[1] + 1 = 2
		 * dp[3] = dp[2] + 1 = 3
		 * dp[4] = 1
		 * dp[5] = dp[2^2] + dp[1] = 2
		 * dp[6] = dp[2^2] + dp[2] = 3
		 * dp[7] = dp[2^2] + dp[3] = 4 
		 * dp[8] = dp[2^2] + dp[2^2] = 2
		 * 
		 * -> 점화식 : dp[i] = dp[i- j*j] + dp[j*j]
		 * 이때, dp[j*j](제곱값은 1)는 1로 고정값이기 때문에 dp[i- j*j]만 비교하면 됨
		 */
		for(int i=2;i<=n;i++) {
			int min=Integer.MAX_VALUE;
			
			// 제곱값부터 값이 변하기 때문에 제곱값 까지 검사
			for(int j=1;j*j<=i;j++) {
				min=Math.min(min, dp[i-j*j]);
			}
			// 1로 고정값인 dp[j*j] 더해주기 
			dp[i]=min+1;
		}
		
		System.out.println(dp[n]);
	}

}
