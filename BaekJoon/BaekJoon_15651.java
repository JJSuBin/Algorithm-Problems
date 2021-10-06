import java.util.Scanner;

public class BaekJoon_15651 {
	static int[] arr;
	static StringBuilder sb=new StringBuilder();
	public static int n,m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[m+1];
		
		dfs(n,m,0);
		System.out.println(sb);
	}
	
	/*
	 * 해당 문제는 중복을 허용하며, 조건을 만족하는 수열을 출력해야 하기 때문에
	 * 해당 노드를 방문했는지 체크하는 visited 없이 깊이만 증가시키며
	 * 모든 경우의 수를 배열에 저장하면 된다.
	 */
	static void dfs(int n, int m, int depth) {
		if(m==depth) {
			for(int i=0;i<m;i++) sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			arr[depth]=i;
			dfs(n,m,depth+1);
		}
	}
}
