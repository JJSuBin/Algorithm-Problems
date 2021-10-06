import java.util.*;

public class BaekJoon_15664 {
	// 입력 순서를 지키기 위해 HashSet이 아닌 LinkedHashSet을 사용해야 한다. 
	static LinkedHashSet<String> set=new LinkedHashSet<>();
	static int n,m,arr[],print[];
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		print=new int[m];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr); // 정렬된 배열 사용
		dfs(0,0);
		
		// LinkedHashSet에 저장된 수열 출력
		Iterator iter=set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	static void dfs(int depth, int start) {
		// 선택된 m개의 숫자로 만들어진 수열을 LinkedHashSet에 저장
		if(depth==m) {
			StringBuilder sb=new StringBuilder();
			for(int i:print)
				sb.append(i).append(" ");
			set.add(sb.toString());
			return;
		}
		
		// n개의 숫자중 m개의 숫자를 중복없이 선택
		for(int i=start;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				print[depth]=arr[i];
				dfs(depth+1,i+1);
				visited[i]=false;
			}
		}
	}
}
