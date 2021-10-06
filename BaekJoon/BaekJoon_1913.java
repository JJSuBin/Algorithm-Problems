import java.io.*;
import java.util.*;

public class BaekJoon_1913 {
	// n*n 숫자는 시계 반대 방향으로 줄어든다.
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int n=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n][n];
		int num=n*n; // 배열의 (0,0)은 n*n 부터 시작
		int x=0,y=0,direction=0,px=0,py=0;
		
		while(num>0) {
			int nx=x+dx[direction]; // 다음 좌표 계산
			int ny=y+dy[direction];
			
			/*
			 * 방향이 바뀌는 지점은 배열의 범위를 벗어나거나 
			 * 배열에 이미 값이 들어있는 경우이다. 따라서 다음 좌표를 계산했을 때
			 * 해당 조건에 만족하면 방향을 변경하여 좌표를 계산해야 한다. 
			 */
			if(nx<0||nx>=n||ny>=n||ny<0||arr[nx][ny]!=0) {
				direction++; // 방향 변겅
				if(direction==4)
					direction=0;
				
				// 변경한 방향으로 다시 다음 좌표 계산
				nx=x+dx[direction]; 
				ny=y+dy[direction];
			}
			
			arr[x][y]=num--; // 숫자 저장
			x=nx; // 다음 좌표로 갱신
			y=ny;
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				// m의 값을 갖는 행,열 찾기
				if(arr[i][j]==m) {
					px=i;
					py=j;
				}
				sb.append(arr[i][j]+" ");
			}
			/*
			 * m의 값을 갖는 행,열을 바로 출력하기 위해 
			 * 마지막 행은 줄바꿈을 하지 않는다.
			 */
			if(i==n-1)
				continue;
			sb.append('\n');
		}
		
		System.out.println(sb); // 배열 출력
		System.out.println((px+1)+" "+(py+1)); // m의 위치를 1행, 1열로 바꿔 출력(각 값에 +1하기)
	}

}
