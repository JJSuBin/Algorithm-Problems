import java.util.Scanner;
/*
 * 미모제이션?
 * 처음 방문하는 재귀라면 계산을 통해 얻은 값을 메모리에 저장(기록)하고, 
 * 이 후 재방문을 할 경우 다시 계산하는 것이 아닌 저장 된 값을 사용
 */
public class BaekJoon_9184 {
	/*
	 * 함수 w에서 a, b, c 중 20이 넘어가게 되면 w(20, 20, 20)을 호출하고,
	 * 0 이하일 경우는 1을 반환하기 때문에
	 * 각 배열의 크기가 21 (0~20)을 넘기지 않는다.
	 */
	static int[][][] dp=new int[21][21][21];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			if(a==-1&&b==-1&&c==-1) break;
			
			System.out.println("w("+a+", "+b+", "+c+")"+" = "+w(a,b,c));
		}
	}
	public static int w(int a, int b, int c) {
		// a,b,c가 0 초과 20 이하면서 저장한 값이 있으면 반환
		if(a>=0&&a<=20&&b>=0&&b<=20&&c>=0&&c<=20) {
			if(dp[a][b][c]!=0) 
				return dp[a][b][c];
		}
		if(a<=0||b<=0||c<=0) 
				return 1;
		//20을 초과하는 a, b, c 값은 20으로 조정되기 때문에 d[20][20][20]에 할당
		else if(a>20||b>20||c>20) 
				return dp[20][20][20]=w(20,20,20);
		if (a < b && b < c) 
				return dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		
		return dp[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}
}
