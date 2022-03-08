import java.util.*;

public class 주사위굴리기_14499 {
	static int[][] map;
	static int n,m,x,y,k;
	static int[] dice=new int[6]; // 0:위, 1:동, 2:남, 3:서, 4:북, 5:아래
	static int[] dx= {0,0,0,-1,1}; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	static int[] dy= {0,1,-1,0,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		k=sc.nextInt(); // 명령의 개수
		
		map=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]=sc.nextInt();
		
		for(int i=0;i<k;i++) {
			int dir=sc.nextInt();
			bfs(dir);
			
			// 여기서 주사위 상단 값 출력하게 되면 주사위가 맵을 벗어난 경우도 출력되게 됨 
		}
		
		
	}
	
	static void bfs(int dir) {
		int nx=x+dx[dir]; // dir 방향으로 이동
		int ny=y+dy[dir];
		
		if(nx<0||ny<0||nx>=n||ny>=m) // 맵을 벗어난 경우
			return;
		
		move_dice(dir); // 주사위 굴리기
		
		if(map[nx][ny]==0) // 이동한 칸에 쓰여 있는 수가 0이면 
			map[nx][ny]=dice[5]; // 주사위 바닥면에 쓰여있는 수가 칸에 복사
		
		else { // 0이 아닌 경우에는
			dice[5]=map[nx][ny]; // 칸에 쓰여있는 수가 주사위 바닥면으로 복사
			map[nx][ny]=0; // 칸에 쓰여있는 수는 0
		}
		
		// 주사위 위치 갱신
		x=nx;
		y=ny;	
		
		System.out.println(dice[0]);
	}
	
	static void move_dice(int dir) {
		int[] temp=dice.clone();
		
		if(dir==1) { // 동
			dice[1]=temp[0]; // 위가 동으로
			dice[5]=temp[1]; // 동이 아래로
			dice[3]=temp[5]; // 아래가 서로
			dice[0]=temp[3]; // 서가 위로
		}
		else if(dir==2) { // 서
			dice[3]=temp[0]; // 위가 서로
			dice[0]=temp[1]; // 동이 위로
			dice[1]=temp[5]; // 아래가 동으로
			dice[5]=temp[3]; // 어가 아래로
		}
		else if(dir==3) { // 남
			dice[2]=temp[0]; // 위가 남으로
			dice[0]=temp[4]; // 북이 위로
			dice[4]=temp[5]; // 아래가 북으로
			dice[5]=temp[2]; // 남이 아래로
		}
		else { // 북
			dice[4]=temp[0]; // 위가 북으로
			dice[0]=temp[2]; // 남이 위로
			dice[5]=temp[4]; // 북이 아래로
			dice[2]=temp[5]; // 아래가 남으로
		}
	}
}
