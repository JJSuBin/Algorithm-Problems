import java.util.*;

class Point_21610 {
	int x,y;
	
	public Point_21610(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_21610 {
	static int n,m;
	static int[][] map;
	static boolean[][] check;
	static ArrayList<Point_21610> cloud=new ArrayList<>(); // 구름 위치 저장
	static int[][] move= {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new int[n+1][n+1];
		check=new boolean[n+1][n+1];
		
		// 초기 구름의 위치 삽입
		cloud.add(new Point_21610(n,1));
		cloud.add(new Point_21610(n,2));
		cloud.add(new Point_21610(n-1,1));
		cloud.add(new Point_21610(n-1,2));

		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				map[i][j]=sc.nextInt();

		for(int i=0;i<m;i++) {
			int d=sc.nextInt();
			int s=sc.nextInt();
			
			// d방향으로 s칸 만큼 모든 구름 이동
			for(int j=0;j<s;j++) {
				for(int k=0;k<cloud.size();k++) {
					Point_21610 p=cloud.get(k);
					int nx=p.x+move[d][0];
					int ny=p.y+move[d][1];
					
					// 이동 좌표가 배열 밖으로 넘어간 경우는 인덱스 조정
					if(!(nx<=n&&ny<=n&&nx>=1&&ny>=1)) {
						/*
						 * x 좌표가 왼쪽으로 넘어간 경우는 오른쪽 끝 값으로 변경
						 * 오른쪽으로 넘거간 경우는 왼쪽 끝 값으로 변경
						 * 
						 * y 좌표가 위쪽으로 넘어간 경우는 맨 아랫 값으로 변경
						 * 아랫쪽으로 넘어간 경우는 맨 위 값으로 변경
						 * 
						 * 이때 배열 인덱스는 1~n 이라는 것 주의!
						 */
						if(nx==0) nx=n;
						else if(nx==n+1) nx=1;
						
						if(ny==0) ny=n;
						else if(ny==n+1) ny=1;
					}
					
					// 이동한 구름 좌표로 갱신
					cloud.set(k,new Point_21610(nx,ny));
				}
			}
			
			// 구름이 있는 곳에 비 뿌리기(배열 값 1 증가)
			for(int j=0;j<cloud.size();j++) {
				Point_21610 p=cloud.get(j);
				map[p.x][p.y]+=1;
				
				check[p.x][p.y]=true; // 비가 있던 곳 체크
			}
			
			// 대각선에 물이 있는 칸 개수 count
			for(int j=0;j<cloud.size();j++) {
				Point_21610 p=cloud.get(j);
				int count=0;
			
				// move 배열에서 인덱스가 2,4,6,8이 대각선 방향
				for(int k=2;k<=8;k+=2) {
					int nx=p.x+move[k][0];
					int ny=p.y+move[k][1];
					
					/*
					 * 물복사버그 마법은 범위를 벗어난 곳은 count 하지 않기 때문에
					 * 배열 인덱스 조정 과정이 필요 없다.  
					 */
					if(nx<=n&&ny<=n&&nx>=1&&ny>=1) 
						if(map[nx][ny]!=0)
							count++;
				}
				
				map[p.x][p.y]+=count;
			}
			
			cloud.clear(); // 구름 소멸
			
			/*
			 * 구름이 있었던 칸을 제외한 나머지 칸 중 비의 양이 2 이상인 칸들은
			 * 구름 생성 후 물의 양 2 감소 
			 */
			for(int x=1;x<=n;x++) {
				for(int y=1;y<=n;y++) {
					// 이전에 비가 있던 자리는 넘어간다.
					if(check[x][y])
						continue;
					
					// 구름 생성
					if(map[x][y]>=2) {
						map[x][y]-=2;
						cloud.add(new Point_21610(x,y));
					}
				}
			}
			
			// 다음 경우를 위해 구름이 있던 자리 체크하는 배열 초기화
			check=new boolean[n+1][n+1];
		}
		
		// 물의 양 합 구하기
		int result=0;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				result+=map[i][j];
		
		System.out.println(result);
	}
}
