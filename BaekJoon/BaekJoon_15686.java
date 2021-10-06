import java.util.*;

class Position_15686 {
	int x;
	int y;
	
	public Position_15686(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_15686 {
	public static int[][] city;
	/*
	 * chicken 연결리스트에는 치킨집의 좌표를 저장
	 * house 연결리스트에는 집의 좌표를 저장 
	 */
	public static ArrayList<Position_15686> chicken=new ArrayList<Position_15686>();;
	public static ArrayList<Position_15686> house=new ArrayList<Position_15686>();
	public static boolean[] visited;
	public static int n,m;
	public static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		city=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				city[i][j]=sc.nextInt();
				
				// 입력받은 값이 1이라면 house에 해당 좌표를 저장
				if(city[i][j]==1)
					house.add(new Position_15686(i,j));
				
				// 입력받은 값이 2라면 chicken에 해당 좌표를 저장
				if(city[i][j]==2)
					chicken.add(new Position_15686(i,j));
			}
		}
		
		visited=new boolean[chicken.size()];
		
		dfs(0,0);
		System.out.println(min);
	}
	
	// 백트래킹
	public static void dfs(int start, int depth){
		// 입력받은 m개의 치킨집이 선택되었다면
		if(depth==m) {
			int result=0;
			
			// 각 집으로부터 선택된 치킨집까지의 최단 거리를 구한다.
			for(int i=0;i<house.size();i++) {
				// m개의 치킨 집 중 i번째 집으로부터 가장 짧은 치킨거리를 구한다.
				int temp=Integer.MAX_VALUE;
				
				for(int j=0;j<chicken.size();j++) {
					if(visited[j]==true) {
						int dis=distance(house.get(i).x,house.get(i).y,
								chicken.get(j).x,chicken.get(j).y);
						
						temp=Math.min(temp, dis);
					}
				}
				// 각 치킨집의 거리의 누적 합을 구한다. = 도시의 치킨거리
				result+=temp;
			}
			// 가장 작은 도시의 치킨거리를 구한다.
			min=Math.min(result, min);
			return;
		}
		
		/*
		 * 백트래킹
		 * 총 n개의 치킨집 중 m개를 선택하는 과정
		 */
		for(int i=start;i<chicken.size();i++) {
			visited[i]=true; // 방문처리
			dfs(i+1,depth+1); // 선택의 중복을 없애기 위해 i+1을 start로 전달
			visited[i]=false; // 재귀 과정이 끝났다면 다음 경우의 수를 위해 값 초기화
		}
		
	}
	
	// 두 좌표간의 거리를 구하는 함수
	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

}
