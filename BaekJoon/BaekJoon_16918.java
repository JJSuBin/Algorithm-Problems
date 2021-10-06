import java.util.*;

public class BaekJoon_16918 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int[][] boomtime; // 폭탄이 설치된 시간을 저장하는 변수(time 기준)
	static char[][] map;
	static int r,c,n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		n=sc.nextInt();
		
		map=new char[r][c];
		boomtime=new int[r][c];
		
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				map[i][j]=str.charAt(j);
				
				// 처음 폭탄이 터져야 하는 시간은 시작 후 3초뒤
				if(map[i][j]=='O')
					boomtime[i][j]=3;
			}
		}
			
		int time=1; // 1초 동안 봄버맨은 아무것도 하지 않기 때문에 1로 초기화 후 시작
		while(time<n) {
			time++; // 시간 증가
			boomberman(time); // 붐버맨이 새로운 폭단을 설치하는 시간을 2초->4초->6초...
			if(time==n) break;
			
			time++;
			boom(time); // 폭탄이 터지는 시간은 3초->5초->7초...
			if(time==n) break;
		}
		
		printmap();
	}
	
	// 붐버맨이 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치하는 함수
	static void boomberman(int time) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='.') {
					map[i][j]='O';
					/*
					 * time시간에 설치된 폭탄은 3초 뒤에 폭발하기 때문에
					 * boomtime 배열에 time+3을 저장한다.
					 */
					boomtime[i][j]=time+3;
				}
			}
		}
	}
	
	// 폭탄이 터지는 함수
	static void boom(int time) {
		// 배열의 모든 칸을 탐색하면서 터져야하는 time 값을 갖는 위치를 찾는다.
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(boomtime[i][j]==time) {
					map[i][j]='.'; // 폭탄 위치 초기화
					// 상,하,좌,우 초기화
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						
						if(nx<0||ny<0||nx>=r||ny>=c)
							continue;
						
						map[nx][ny]='.';
					}
				}
			}
		}
	}
	
	// 맵 출력 함수
	static void printmap() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]+"");
			}
			System.out.println();
		}
	}
}
