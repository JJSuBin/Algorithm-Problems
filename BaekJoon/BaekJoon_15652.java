import java.util.Scanner;

public class BaekJoon_15652 {
	static int[] arr;
	static StringBuilder sb=new StringBuilder();
	public static int n,m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[m+1];
		dfs(1,0);
		System.out.println(sb);
	}
	
	/*
	 * 첫 번째 값 이상의 값을 가진 수열들만 출력하야하기 때문에
	 * 첫 번째 값을 저장한 at 변수를 매개변수로 하는 함수를 재귀호출 한다. 
	 */
	static void dfs(int at, int depth) {
		if(m==depth) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=at;i<=n;i++) {
			arr[depth]=i;
			dfs(i,depth+1);
		}
	}
}
