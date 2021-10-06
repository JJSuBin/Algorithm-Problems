import java.util.Scanner;

public class BaekJoon_15649 {
	public static int[] arr; // 값을 담을 배열
	public static boolean[] visit; // 유망한 노드인지 검사하기 위한 배열(재귀를 하면서 이미 방문한 노드라면 건너뛰기)
	public static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		arr=new int[m+1];
		visit=new boolean[n+1];
		dfs(n,m,0);
		System.out.println(sb);
    }
	
	public static void dfs(int n, int m, int depth) {
		/*
		 * 재귀가 깊어질때 마다 depth 변수를 1씩 증가시키고 이 값이
		 * m과 같아지면 탐색 과정 중 값을 담았던 arr 배열을 출력한다.
		 */ 
		if(depth==m) {
			for(int i=0;i<m;i++) sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			// 해당 노드(값)를 방문하지 않았다면
			if(!visit[i]) {
				visit[i]=true; // 해당 노드를 방문 상태로 변경
				arr[depth]=i; 
				dfs(n,m,depth+1);
				visit[i]=false; // 처리가 끝났다면 방문상태 다시 변경
			}
		}
	}
}
