import java.util.Scanner;
/*
 * 해당 문제 경우 int형 범위를 넘어가기 때문에 long 타입을 써줘야 한다
 * long형 -> -1로 초기화 과정 거쳐줘야 함
 * Long형 -> null로 초기화가 되어있음
 */
public class BaekJoon_9461 {
	static Long[] dp=new Long[101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int testcase=sc.nextInt();
		
		dp[0]=0L;
		dp[1]=1L;
		dp[2]=1L;
		dp[3]=1L;
		
		while(testcase-->0) {
			int n=sc.nextInt();
			System.out.println(triangle(n));
		}
	}
	public static Long triangle(int n) {
		if(dp[n]==null) dp[n]=(triangle(n-2)+triangle(n-3));
		return dp[n];
	}
}
