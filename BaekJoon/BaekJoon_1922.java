import java.io.*;
import java.util.*;

class Edge_1922 implements Comparable<Edge_1922> {
	int start, end, weight;
	
	public Edge_1922(int start, int end, int weight) {
		this.start=start;
		this.end=end;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Edge_1922 o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
}
 
public class BaekJoon_1922 {
	static int[] parent;
	static int n,m;
	static ArrayList<Edge_1922> graph=new ArrayList<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		parent=new int[n+1];
		
		for(int i=1;i<=n;i++) 
			parent[i]=i;
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			
			graph.add(new Edge_1922(a,b,cost));
		}
		
		Collections.sort(graph); // 가중치가 작은 순으로 정렬	
		
		int result=0;
		// 가중치가 작은 노드부터 결과 그래프에 추가 : 크루스칼 알고리즘
		for(int i=0;i<graph.size();i++) {
			Edge_1922 e=graph.get(i); 
			
			// 사이클이 발생하지 않는다면
			if(find(e.start)!=find(e.end)) {
				result+=e.weight; // 결과 그래프의 가중치 누적
				union(e.start,e.end); // 두 노드 그룹으로 묶어주기
			}
		}
		System.out.println(result);
	}
	
	// 그래프에 사이클이 생기지 않도록 union-find 사용하여 그룹으로 묶어주기
	static void union(int a, int b) {
		a=find(a);
		b=find(b);
		
		if(a!=b)
			parent[b]=a;
	}
	
	static int find(int x) {
		if(x==parent[x])
			return x;
		
		return parent[x]=find(parent[x]);
	}
}
