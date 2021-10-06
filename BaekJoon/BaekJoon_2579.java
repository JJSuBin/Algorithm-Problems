import java.util.Scanner;
/*
 * 현재 인덱스에 대해 두 칸 전(n-2)의 '메모이제이션 값'과 
 * 한 칸 전(i-1)의 값 + 셋 째칸 전(i-3)의 '메모이제이션 값' 중 
 * 큰 값을 현재 i 계단의 값과 합하여 DP배열에 저장한다.
 * 이떄 한칸 전의 값도 메모제이션 한 값을 사용하면 이전 계단을 밟은 상태인지 아닌지 알 수가 없다.
 */
public class BaekJoon_2579 {
	static int n;
	static int[] stair;
	static Integer[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		stair=new int[n+1];
		dp=new Integer[n+1];
		
		for(int i=1;i<=n;i++)
			stair[i]=sc.nextInt();
		
		dp[0]=stair[0]; // 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1]=stair[1];
		
		/*
		 * 이떄 아래 find 함수에서 i-3의 계산으로 인해
		 * 세 번째 칸 이전 것의 값을 찾을 때 i가 3 미만의 수라면 
		 * 음수로 참조할 수 없는 인덱스에 접근하게 된다
		 * 따라서 이에 대한 예외 처리를 해주어야 한다.
		 */
		if(n>=2) dp[2]=stair[1]+stair[2];
		
		System.out.println(find(n));
	}
	public static int find(int n) {
		if(dp[n]==null)
			/*
			 * n의 이전 계단인 n-1은 재귀호출이 아닌 이미 입력받은 배열의 값을 더해줘야 한다.
			 * 만약 n-1을 재귀호출 한다면 호출되는 함수 중 n-3을 밟은 상태인지 알 수 없다.
			 * 따라서 연속된 계단인 경우에는 재귀호출을 하면 X
			 */
			dp[n]=Math.max(find(n-2), find(n-3)+stair[n-1])+stair[n];
		return dp[n];
	}
}
