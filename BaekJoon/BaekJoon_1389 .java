import java.util.*;

public class BaekJoon_1389 {
	static int n,m,min=Integer.MAX_VALUE,person=0;
	static final int INF=(int)1e9;
	static int[][] graph;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		graph=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				// 자기 자신으로 가는 값은 0으로 초기화
				if(i==j)
					graph[i][j]=0;
				// 그 외의 경우는 최댓값으로 초기화
				else
					graph[i][j]=INF;
			}
		}
		
		// 친구관계 입력받기
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph[a][b]=graph[b][a]=1; // 양방향
		}
		
		// 플로이드 워셜 알고리즘
		for(int k=1;k<=n;k++) 
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
		
		// 모든 사람의 케빈 베이컨 수 검사
		for(int i=1;i<=n;i++) 
			kabinbacon(i);
		
		System.out.println(person);
	}
	
	static void kabinbacon(int index) {
		int sum=0;
		
		// index 사람의 케빈 베이컨 수 구하기
		for(int i=1;i<=n;i++)
			sum+=graph[index][i];
		
		// 최솟값이 갱신된다면 해당 사람 번호 저장
		if(min>sum) {
			min=sum;
			person=index;
		}
	}
}
