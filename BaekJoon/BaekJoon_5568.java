import java.util.*;

public class BaekJoon_5568 {
	static int n,k;
	static int[] card,arr;
	static boolean[] visited;
	static HashSet<String> set=new HashSet<>(); // 중복을 없애기 위해 HashSet 사용
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		card=new int[n];
		visited=new boolean[n];
		arr=new int[n];
		
		for(int i=0;i<n;i++)
			card[i]=sc.nextInt( );
		
		dfs(0);
		System.out.println(set.size()); // HashSet의 크기가 만들 수 있는 정수의 개수
	}
	
	static void dfs(int depth) {
		// k개의 수 선택
		if(depth==k) {
			String str="";
			for(int i=0;i<arr.length;i++)
				str+=arr[i];
			
			// 만들어진 숫자를 HashSet에 삽입, 중복값은 제거된다. 
			set.add(str);
			return;
		}
		
		// 백트래킹을 사용하여 n개의 숫자중 k개 선택
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				arr[depth]=card[i];
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
}
