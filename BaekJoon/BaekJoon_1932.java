import java.util.Scanner;
/*
 * dp에 arr의 맨 마지막 줄을 저장한 후 아래서 부터 합을 구해나간다.
 * 맨 아랫줄의 위의 줄의 값을 구할 때는 깊이는 1 크고 인덱스는 같거나 1 큰 값 중 
 * 큰 값과 해당 자리의 값을 더한 값이 dp 값이 된다.
 * 이러한 과정을 깊이가 n-1과 같아질 때 까지 반복한다.
 */
public class BaekJoon_1932 {
	static int[][] arr;
	static Integer[][] dp;
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		arr=new int[n][n];
		dp=new Integer[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		// 삼각형의 제일 아랫줄의 값을 dp의 마지막 줄에 저장한다
		for(int i=0;i<n;i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		
		System.out.println(find(0,0));
	}
	
	// depth는 깊이(행), idx는 인덱스(열)를 의미
	public static int find(int depth, int idx) {
		// 마지막 행일 경우 현재 위치의 dp 값 반환
		if(depth==n-1) return dp[depth][idx];
		
		// 탐색하지 않았던 값일 경우 
		if(dp[depth][idx]==null) {
			/*
			 바로 다음행의 인덱스와 그 오른쪽의 인덱스 중 
			 큰 값 찾아 dp에 현재 인덱스의 값과 더하여 저장
			*/
			dp[depth][idx]=Math.max(find(depth+1, idx), find(depth+1, idx+1))+arr[depth][idx];
		}
		return dp[depth][idx];
	}
}
