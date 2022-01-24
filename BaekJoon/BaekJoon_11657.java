import java.io.*;
import java.util.*;

class Node_11657 {
	int end, weight;
	
	public Node_11657(int end, int weight) {
		this.end=end;
		this.weight=weight;
	}
}

public class BaekJoon_11657 {
	static int n,m;
	static ArrayList<ArrayList<Node_11657>> graph=new ArrayList<>();
	static long[] dist;
	static final int INF=(int)1e9;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		dist=new long[n+1];
		
		// 초기화
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
			dist[i]=INF;
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node_11657(b,c));
		}
		
		StringBuilder sb=new StringBuilder();
		if(Bellman_Ford())
			sb.append(-1).append('\n');
		else {
			for(int i=2;i<=n;i++) {
				if(dist[i]==INF)
					sb.append(-1).append('\n');
				else
					sb.append(dist[i]).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean Bellman_Ford() {
		dist[1]=0; // 시작지점은 0으로 설정
		boolean update=false;
		
		// (정점 개수 - 1)번 동안 최단거리 갱신 작업을 반복
		for(int i=1;i<n;i++) {
			update=false;
			
			for(int j=1;j<=n;j++) {
				for(Node_11657 node:graph.get(j)) {
					if(dist[j]==INF)
						break;
					
					if(dist[node.end]>dist[j]+node.weight) {
						dist[node.end]=dist[j]+node.weight;
						update=true;
					}
				}
			}
			
			// 더이상 최단거리 갱신이 이루어지지 않으면 반복문 종료
			if(!update)
				break;
		}
		
		// 한번 더 최단거리가 갱신된다면 음수 사이클이 발생한 경우 -> true return
		if(update) {
		for(int i=1;i<=n;i++) {
			for(Node_11657 node:graph.get(i)) {
				if(dist[i]==INF)
					break;
						
				if(dist[node.end]>dist[i]+node.weight) 
					return true;
				}
			}
		}
		
		return false;
	}
}
