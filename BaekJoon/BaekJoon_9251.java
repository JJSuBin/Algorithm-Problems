import java.util.*;

public class BaekJoon_9251 {
	static char[] str1;
	static char[] str2;
	
	// dp에는 각 수열의 부분 수열을 늘려가며 찾은 부분 수열 길이의 누적 합이 저장되어 있다.
	static Integer[][] dp; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		// toCharArray() : 문자열을 char[] 배열로 반환해주는 메소드
		str1=sc.nextLine().toCharArray();
		str2=sc.nextLine().toCharArray();
		
		dp=new Integer[str1.length][str2.length];
		
		System.out.println(LCS(str1.length-1,str2.length-1));
	}
	
	/*
	 * LCS : Longest Common Subsequance(긴 공통된 부분수열)
	 * 임의의 두 수열에서 각각의 부분수열 중 서로 같은 부분 수열 중에서 가장 긴 부분 수열을 의미한다.
	 * 
	 * x번째 원소와 y번째 원소가 같다면 (x-1,y-1)의 LCS 길이의 +1이 된다.
	 * 같지 않다면 LCS(x-1,y)와 LCS(x,y-1) 중 큰 값을 갖는다. 
	 */
	public static int LCS(int x, int y) {
		// 인덱스 밖 (공집합)일 경우 0 반환
		if(x==-1||y==-1)
			return 0;
		
		if(dp[x][y]==null) {
			dp[x][y]=0;
			
			// str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
			if(str1[x]==str2[y])
				dp[x][y]=LCS(x-1,y-1)+1;
			// 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
			else 
				dp[x][y]=Math.max(LCS(x-1,y),LCS(x,y-1));
		}
		return dp[x][y];
	}
}
