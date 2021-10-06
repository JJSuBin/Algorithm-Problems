import java.util.Scanner;

public class BaekJoon_15650 {
	static int n,m;
	static int[] arr;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[m+1];
		dfs(1,0);
		System.out.println(sb);
	}
	
	// 출력 시작 값과 깊이 값을 매개변수로 하는 dfs 함수
	static void dfs(int start, int depth) {
		// 깊이가 m과 같아지면 배열에 저장된 값들 한번에 출력
		if(m==depth) {
			for(int i=0;i<m;i++) sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		/*
		 * 해당 문제는 n=4, m=2인 경우
		 * (1,2) (1,3) (1,4) (2,3) (2,4) (3,4) 와 같이
		 * 시작 값의 이후 값들만 출력해야 한다. 따라서 시작 지점과 깊이를 매개변수로 하여
		 * 시작 이전의 값들을 출력하지 않게 구성해야 한다.
		 */
		for(int i=start;i<=n;i++) {
			arr[depth]=i;
			dfs(i+1,depth+1);
		}
	}
}
