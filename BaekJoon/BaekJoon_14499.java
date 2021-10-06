import java.util.*;

public class BaekJoon_14499 {
	static int n,m,x,y,k;
	static int[][] map;
	static int[] dice=new int[7]; 
	static int[] dx= {0,0,0,-1,1}; // 인덱스 1부터 동,서,북,남
	static int[] dy= {0,1,-1,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		k=sc.nextInt();
		
		map=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]=sc.nextInt();
		
		for(int i=0;i<k;i++) {
			int command=sc.nextInt();
			
			int nx=x+dx[command];
			int ny=y+dy[command];
			
			// 주사위가 이동한 곳이 배열 범위 내에 있다면
			if(nx>=0&&ny>=0&&nx<n&&ny<m) {
				changedice(command); // 해당 방향으로 굴리기
				
				// 굴린 곳의 지도 값이 0이 아니라면 
				if(map[nx][ny]!=0) {
					dice[6]=map[nx][ny]; // 주사위의 바닥에 해당 숫자 복사
					map[nx][ny]=0; // 지도 값 초기화
				}
				// 굴린 곳의 지도 값이 0이라면
				else
					map[nx][ny]=dice[6]; // 주사위의 바닥에 적힌 숫자를 지도에 복사
				
				// 주사위 위치 갱신
				x=nx;
				y=ny;
				System.out.println(dice[1]); // 주사위의 상단 값 출력
  			}
		}
	}
	
	static void changedice(int dir) {
		int[] temp=dice.clone();
		
		/*
		 * 주사위의 인덱스는 아래와 같다.
		 *        2
		 *      4 1 3     -> 윗면은 1, 아랫면은 6
		 *        5
		 *        6
		 * 이러한 주사위를 dir 방향으로 굴렸을 때 
		 * 주사위의 변한 위치를 배열의 값을 변경하는 방식으로 생각해준다. 
		 */
		if(dir==1) {
			dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } 
		else if(dir==2) {
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        } 
		else if(dir==3) {
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        }
		else {
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
	}
}
