import java.util.*;

public class BaekJoon_15654 {
	static int n,m;
	static int[] num, print;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		num=new int[n+1];
		print=new int[n+1];
		visited=new boolean[n+1];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		Arrays.sort(num); // 예제와 같이 출력하기 위해 정렬된 배열 사용
		
		dfs(0);
	}
	
	static void dfs(int depth) {
		// 선택된 숫자의 개수가 m개가 됐다면 선택된 숫자 출력
		if(depth==m) {
			for(int i=0;i<depth;i++) {
				System.out.print(print[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 백트래킹
		for(int i=1;i<=n;i++) {
			// 이전에 선택되지 않은 숫자라면
			if(!visited[i]) {
				visited[i]=true; // 방문처리
				print[depth]=num[i]; // 숫자 저장
				dfs(depth+1); // 깊이를 1 증가하고 재귀호출
				visited[i]=false; // 재귀호출이 끝난다면 배열 값 되돌리기
			}
		}
	}
}
