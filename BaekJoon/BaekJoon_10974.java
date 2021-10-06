import java.util.*;

public class BaekJoon_10974 {
	static int n;
	static boolean[] visited; 
	static int[] arr;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		visited=new boolean[n+1];
		arr=new int[n];
		
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int depth) {
		if(depth==n) {
			// arr 배열에 저장된 숫자로 만든 하나의 수열 저장
			for(int i=0;i<arr.length;i++)
				sb.append(arr[i]+" ");
			sb.append('\n');
			return;
		}
		
		for(int i=1;i<=n;i++) {
			// 사용하지 않은 숫자라면
			if(visited[i]==false) {
				visited[i]=true; // 사용처리
				arr[depth]=i; // 수열에 저장
				dfs(depth+1); // 깊이 1 증가시키고 재귀호출
				visited[i]=false; // 다음 경우의 수를 위해 값 되돌리기
			}
		}
	}
}
