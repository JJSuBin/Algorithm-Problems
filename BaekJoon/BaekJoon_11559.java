import java.util.*;

class Puyo_11559 {
	int x,y;
	
	public Puyo_11559(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_11559 {
	static char[][] map=new char[12][6];
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int count=0,result=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<12;i++) {
			String str=sc.next();
			for(int j=0;j<6;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		while(true) {
			visited=new boolean[12][6];
			
			// 연산을 수행 했는지 안했는지 체크하는 변수
			boolean flag=false;
			
			// 같은 뿌요를 찾는 과정
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(!visited[i][j]&&map[i][j]!='.') {
						count=1; // i행 j열의 뿌요를 포함하기 때문에 1로 초기화
						
						/*
						 * 같은 색의 뿌요가 4개 이상 있다면 제거하기
						 * 이때 탐색을 시작할 좌표와 색깔을 매개변수로 전달
						 */
						if(findpuyo(i,j,map[i][j])) {
							flag=true; // 연산 수행
							bfs(i,j,map[i][j]); // 뿌요 제거함수 실행
						}
					}
				}
			}
			
			if(flag)
				result++; // 연쇄 횟수 증가
			
			// 연산이 수행되지 않았다면 아래로 내릴 뿌요도 없기 때문에 while문 종료
			else
				break;
			
			// 뿌요가 터지는 연산이 수행 됐다면 아래로 내리기
			while(true) {
				boolean check=false; // 연상 수행 여부 체크
				
				check=gravity(check);
				
				// 아래로 내려갈 뿌요가 없다면 while문 종료
				if(!check)
					break;
			}
		}
		
		System.out.println(result);
	}
	
	// x행 y열을 기준으로 주변에 color와 같은 색상의 뿌요를 제거하는 함수
	public static void bfs(int x, int y, char color) {
		Queue<Puyo_11559> q=new LinkedList<>();
		q.add(new Puyo_11559(x,y));
		
		while(!q.isEmpty()) {
			Puyo_11559 puyo=q.poll();
			
			x=puyo.x;
			y=puyo.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				// 배열의 범위를 벗어났거나 같은 색깔이 아니라면 넘어간다.
				if(nx>=12||ny>=6||nx<0||ny<0||map[nx][ny]!=color)
					continue;
				
				/*
				 * x행 y열을 기준으로 주변에 color와 같은 색생의 좌표를
				 * 4개 이상의 개수를 셀 때 true 처리가 되었기 때문에 해당 좌표에 있는 쀼요들을 떠뜨리기
				 */
				if(visited[nx][ny]&&map[nx][ny]==color) {
					map[nx][ny]='.'; // 떠뜨리기
					q.add(new Puyo_11559(nx,ny));
				}
			}
		}
	}
	
	// 주변에 color 색을 갖는 쀼요가 4개 이상 있는지 확인하는 함수
	public static boolean findpuyo(int x, int y, char color) {
		visited[x][y]=true; // 여기서 true 처리 -> bfs 함수에서 true 값인 쀼요를 제거해야 한다.
		
		// 상,하,좌,우 탐색
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 배열 벗어난 경우 넘어간다.
			if(nx>=12||ny>=6||nx<0||ny<0)
				continue;
			
			// 같은 색상이 아니거나 이미 방문처리 된 곳이라면 넘어간다.
			if(map[nx][ny]!=color||visited[nx][ny])
				continue;
			
			count++; // 개수 증가
			findpuyo(nx,ny,color);
		}
		
		if(count>=4) // 주변에 같은 색인 쀼요가 4개 이상이라면 return true
			return true;
		else
			return false;
	}
	
	// 쀼요가 터지고 나서 남아있는 쀼요를 밑으로 내리는 함수
	public static boolean gravity(boolean check) {
		// 배열의 위에 있는 쀼요들을 아래로 옮겨야하기 때문에 값을 줄여나가야 한다.
		for(int i=11;i>0;i--) {
			for(int j=5;j>=0;j--) {
				// 빈 공간 위의 행에 뿌요가 있는 경우는 아래로 내려야 함
				if(map[i][j]=='.'&&map[i-1][j]!='.') {
					check=true;
					map[i][j]=map[i-1][j];
					map[i-1][j]='.';
				}
			}
		}
		
		return check;
	}
}
