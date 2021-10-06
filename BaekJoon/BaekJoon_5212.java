import java.util.*;

public class BaekJoon_5212 {
	static char[][] map;
	static int[][] nummap; // 주변의 육지 개수를 count 하는 배열
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int r,c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		
		map=new char[r][c];
		nummap=new int[r][c];
		
		// 지도 상태 입력받기 
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				char ch=map[i][j];
				int count=0; // 주변의 육지 개수 count
				
				// 바다인 경우는 무시
				if(ch=='.')
					continue;
				
				// 육지인 경우 해당 좌표로부터 상,하,좌,우 탐색
				else {
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						
						// 이동 좌표가 범위 내에 있고, 육지라면 count
						if(nx>=0&&ny>=0&&nx<r&&ny<c) {
							if(map[nx][ny]=='X')
								count++;
						}
					}
				}
				nummap[i][j]=count; // 해당 좌표 4 방향의 육지 개수를 저장한다.
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				/*
				 * 주변에 육지의 개수가 1개 이하라면 
				 * 3면 이상이 바다이기 때문에 해당 좌표 바다로 변경
				 */
				if(nummap[i][j]<2)
					map[i][j]='.';
			
			}		
		}
		
		/*
		 * 새롭게 출력해야 하는 지도는 모든 섬을 포함하는 가장 작은 직사각형이어야 하기 때문에
		 * 육지가 있는 x,y 좌표의 각각 최대, 최솟 값을 찾아 그 범위만큼의 지도를 출력하면 된다.   
		 */
		int lx=Integer.MAX_VALUE;
		int ly=Integer.MAX_VALUE;
		int rx=Integer.MIN_VALUE;
		int ry=Integer.MIN_VALUE;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='X') {
					lx=Math.min(i, lx);
					ly=Math.min(j, ly);
					rx=Math.max(i, rx);
					ry=Math.max(j, ry);
				}
			}
		}
		
		// 지도 출력
		for(int i=lx;i<=rx;i++) {
			for(int j=ly;j<=ry;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
