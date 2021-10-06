import java.util.*;

public class BaekJoon_10819 {
	/*
	 * temp 배열은 num 배열의 순서를 다르게 하여
	 * 조건에 맞는 누적합을 구할 때 num 배열의 정렬 바뀐 값들을
	 * 임시로 저장할때 쓰이는 배열이다. 
	 */
	public static int[] num,temp;
	public static boolean[] visited;
	public static int n,max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		num=new int[n];
		temp=new int[n];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();

		dfs(0);
		System.out.println(max);
	}
	
	// 백트래킹
	public static void dfs(int depth) {
		// 재귀의 깊이가 문자의 개수와 같아진다면 
		if(depth==n) {
			int sum=0; 
			// 조건의 누적합 계산
			for(int i=0;i<n-1;i++)
				sum+=Math.abs(temp[i+1]-temp[i]);
			
			max=Math.max(sum, max); // 최댓값 갱신
			return;
		}
		
		// 백트래킹
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				visited[i]=true; // 방문처리
				temp[depth]=num[i]; // 배열 값 저장
				dfs(depth+1); // 깊이를 1 증가시키고 재귀호출
				// 재귀호출이 끝나면 다음 경우의 수를 위해 값을 되돌린다.
				visited[i]=false;
			}
		}
	}
}
