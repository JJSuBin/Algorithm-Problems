import java.util.*;

/*
 * 해당 문제는 설치할 울타리의 최소 갯수를 구하는 것이 아니기 때문에
 * 울타리의 개수 상관없이 늑대가 양이 있는 칸에 못가게 만들면 된다.
 * 즉, 늑대의 상,하,좌,우 칸에 양이 없으면 늑대는 양에 갈 수 없기 때문에 해당 칸들에 울타리를 설치하면 된다.
 */
public class BaekJoon_16956 {
	static char[][] map;
	static int r,c;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		map=new char[r][c];
		
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		boolean flag=true; 
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				
				// 해당 칸에 늑대가 있다면 상,하,좌,우 탐색
				if(map[i][j]=='W') {
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						
						// 배열 범위를 벗어난 경우 넘어간다.
						if(nx>=r||ny>=c||nx<0||ny<0)
							continue;
						
						/*
						 * 늑대가 이동할 수 있는 칸에 양이 있으면 
						 * 울타리를 어떻게 설치해도 늑대가 양이있는 칸에 갈 수 있는 경우
						 */
						if(map[nx][ny]=='S')
							flag=false;
						
						/*
						 * 늑대가 이동할 수 있는 칸에 양들이 없고
						 * 늑대의 상,하,좌,우 모든 칸에 울타리를 설치한다면 
						 * 늑대는 절대로 양이 있는 칸으로 갈 수 없다. 
						 */
						if(map[nx][ny]=='.')
							map[nx][ny]='D';
					}
				}
			}
		}
		
		// 울타리를 어떻게 설치해도 늑대가 양이있는 칸에 갈 수 있는 경우
		if(flag==false)
			System.out.println(0);
		// 아니라면 맵 출력
		else {
			System.out.println(1);
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();	
			}
				
		}
	}

}
