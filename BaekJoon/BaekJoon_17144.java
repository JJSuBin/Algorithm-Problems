import java.util.*;

public class BaekJoon_17144 {
	static int r,c,t;
	static int[] position=new int[2];
	static int[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		t=sc.nextInt();
		
		map=new int[r][c];
		
		int index=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				map[i][j]=sc.nextInt();
				
				// 공기청정기는 항상 1열에 설치되어 있기 때문에
				if(map[i][j]==-1)
					position[index++]=i;
			}
		}
		
		while(t-->0) {
			map=spreadDust();
			purifier();
		}
		
		System.out.println(calculation());
	}
	
	// 미세먼지가 퍼지는 함수
	static int[][] spreadDust() {
		int[][] temp=new int[r][c]; // 임시배열
		
		for(int x=0;x<r;x++) {
			for(int y=0;y<c;y++) {
				// 공기청정기 위치 표시
				if(map[x][y]==-1) {
					temp[x][y]=-1;
					continue;
				}
				
				/*
				 * temp에는 어떤 x,y에 의해 nx,ny 좌표에 확산된 미세먼지의 양이 저장되어 있다.
				 * 이후 nx,ny가 x,y가 되어 미세먼지가 확산될 때 다른 좌표에 의해 확산된 미세먼지의 양도
				 * 고려해야 하기 때문에 여기서 map 값과 temp 값을 더해주어야 한다. 
				 */
				temp[x][y]+=map[x][y];
				
				for(int k=0;k<4;k++) {
					int nx=x+dx[k];
					int ny=y+dy[k];
					
					// 배열의 범위를 벗어난 경우 넘어간다.
					if(nx>=r||ny>=c|nx<0||ny<0)
						continue;
					// 이동한 곳에 공기청정기가 있는 경우도 넘어간다.
					if(map[nx][ny]==-1)
						continue;
					
					temp[nx][ny]+=(map[x][y]/5); // 주변에 미세먼지 확산
					temp[x][y]-=(map[x][y]/5); // 확산된 만큼 미세먼지 양 감소
				}
			}
		}
		return temp;
	}
	
	/*
	 * 공기청정기에 의한 미세먼지의 이동은 바람의 순환뱡향으로 값을 이동시키면
	 * 방향이 바뀌는 부분이 복잡하기 때문에 바람의 흐름의 반대 방향으로 값을 
	 * 당겨주면 방향의 변화를 생각할 필요 없이 쉽게 이동시킬 수 있다.  
	 */
	static void purifier() {
		// 공기청정기의 위쪽은 반시계방향
		int top=position[0]; 
		
		for(int x=top-1;x>0;x--)
			map[x][0]=map[x-1][0]; // 왼쪽 세로, 아래로 끌어당기기
		
		for(int y=0;y<c-1;y++)
			map[0][y]=map[0][y+1]; // 윗쪽 가로, 왼쪽으로 끌어당기기
		
		for(int x=0;x<top;x++)
			map[x][c-1]=map[x+1][c-1]; // 오른쪽 세로, 위로 끌어당기기
		
		for(int y=c-1;y>1;y--)
			map[top][y]=map[top][y-1]; // 아랫쪽 가로, 오른쪽으로 끌어당기기
		
		map[top][1]=0;
		
		// 공기청정기의 아랫쪽은 시계방향
		int bottom=position[1];
		
		for(int x=bottom+1;x<r-1;x++) // 왼쪽 세로, 위로 끌어당기기
			map[x][0]=map[x+1][0];
		
		for(int y=0;y<c-1;y++)
			map[r-1][y]=map[r-1][y+1]; // 아랫쪽 가로, 왼쪽으로 끌어당기기
		
		for(int x=r-1;x>bottom;x--)
			map[x][c-1]=map[x-1][c-1]; // 오른쪽 세로, 아래로 끌어당기기
		
		for(int y=c-1;y>1;y--)
			map[bottom][y]=map[bottom][y-1]; // 윗쪽 가로, 오른쪽으로 끌어당기기
		
		map[bottom][1]=0;
	}
	
	// t초 후 미세먼지 양 계산
	static int calculation() {
		int sum=2;
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				sum+=map[i][j];
		
		return sum;
	}
}
