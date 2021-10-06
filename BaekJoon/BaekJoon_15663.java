import java.util.*;

public class BaekJoon_15663 {
	// 입력 순서를 지키기 위해 HashSet이 아닌 LinkedHashSet을 사용해야 한다. 
	static LinkedHashSet<String> set=new LinkedHashSet<>();
	static int n,m;
	static int[] num,print;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		print=new int[m];
		visited=new boolean[n];
		num=new int[n];
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		Arrays.sort(num); // 숫자 정렬
		dfs(0);
		
		// LinkedHashSet에 저장된 수열 출력
		Iterator iter=set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	static void dfs(int depth) {
		// m개의 숫자를 선택했다면 선택한 숫자로 만든 수열 LinkedHashSet에 저장
		if(depth==m) {
			StringBuilder sb=new StringBuilder();
			for(int i:print)
				sb.append(i).append(" ");
			set.add(sb.toString());
			return;
		}
		
		// n개의 숫자 중 m개의 숫자 중복 없이 선택
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				print[depth]=num[i];
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
}
