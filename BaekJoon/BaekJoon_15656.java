import java.util.*;

public class BaekJoon_15656 {
	static int n,k;
	static int[] arr,print;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		arr=new int[n];
		print=new int[k];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		// 선택된 k개의 수 sb에 저장 저장
		if(depth==k) {
			for(int i=0;i<print.length;i++)
				sb.append(print[i]+" ");
			sb.append('\n');
			return;
		}
		
		// 백트래킹
		for(int i=0;i<n;i++) {
			print[depth]=arr[i];
			dfs(depth+1);
		}
	}

}
