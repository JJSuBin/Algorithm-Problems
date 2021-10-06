import java.util.*;

class point_3055 {
	int x,y;
	
	public point_3055(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_3055 {
	static char[][] map;
	static int r,c;
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static Queue<point_3055> water=new LinkedList<>();
	static Queue<point_3055> beaver=new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		r=sc.nextInt();
		c=sc.nextInt();
		map=new char[r][c];
	
		for(int i=0;i<r;i++) {
			char[] input=sc.next().toCharArray();
			for(int j=0;j<c;j++) {
				map[i][j]=input[j];
				
				// 물의 좌표를 큐에 삽입
				if(map[i][j]=='*')
					water.add(new point_3055(i,j));
				
				// 비버의 좌푤를 큐에 삽입
				if(map[i][j]=='S')
					beaver.add(new point_3055(i,j));
			}
		}
		
		int time=0;
		while(true) {
			time++; // 시간 증가
			
			/*
			 * 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없기 때문에
			 * 물을 먼저 이동시키고 난 뒤에 고슴도치를 이동해야 한다. 
			 */
			move_water();
			if(move_beaver()) {
				System.out.println(time); // 비버의 굴에 갈 수 있다면 소요시간 출력
				return;
			}
			
			/*
			 * 고슴도치의 위치가 담긴 큐가 비었다는 것은 
			 * 더 이상 고슴도치가 이동할 수 없다는 의미이므로 KAKTUS 출력
			 * 
			 */
			if(beaver.size()==0) {
				System.out.println("KAKTUS");;
				return;
			}
			
		}
	}
	
	// 물이 상,하,좌,우로 이동하는 함수
	static void move_water() {
		int size=water.size();
		for(int i=0;i<size;i++) {
			point_3055 point=water.poll();
			
			for(int j=0;j<4;j++) {
				int nx=point.x+dx[j];
				int ny=point.y+dy[j];
				
				// 배열 범위 이내이며, 비어있는 곳이라면
				if(nx>=0&&ny>=0&&nx<r&&ny<c) {
					if(map[nx][ny]=='.') {
						map[nx][ny]='*'; // 물로 변경
						water.add(new point_3055(nx,ny)); // 새로운 물의 위치 큐에 삽입
					}
				}
			}
		}
	}
	
	// 비버가 움직이는 함수
	static boolean move_beaver() {
		int size=beaver.size();
		for(int i=0;i<size;i++) {
			point_3055 point=beaver.poll();
			
			// 상,하,좌,우 탐색
			for(int j=0;j<4;j++) {
				int nx=point.x+dx[j];
				int ny=point.y+dy[j];
				
				// 배열의 범위 이내이며
				if(nx>=0&&ny>=0&&nx<r&&ny<c) {
					if(map[nx][ny]=='D') { // 이동한 좌표가 비버의 굴이라면 종료
						return true;
					}
					
					// 이동한 좌표가 비어있는 곳이라면
					if(map[nx][ny]=='.') {
						map[nx][ny]='S'; // 배열 값을 고슴도치의 위치를 나타내는 S로 변경
						beaver.add(new point_3055(nx,ny)); // 새로운 고슴도치 위치 큐에 삽입
					}
				}
			}
		}
		return false;
	}
}
