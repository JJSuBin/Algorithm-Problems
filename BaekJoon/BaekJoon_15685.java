import java.util.*;

public class BaekJoon_15685 {
	static boolean[][] map=new boolean[101][101];
	// x좌표 증가, y좌표 감소, x좌표 감소, y좌표 증가 순서
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,-1,0,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt(); 
			int d=sc.nextInt(); // 방향
			int g=sc.nextInt(); // 세대
			
			DragonCurve(x,y,d,g);
		}
		
		int result=0;
		for(int i=0;i<100;i++) 
			for(int j=0;j<100;j++) 
				// 정사각형의 네 꼭짓점이 모두 드래곤 커브인 경우 count
				if(map[i][j]&&map[i][j+1]&&map[i+1][j]&&map[i+1][j+1])
					result++;
		
		System.out.println(result);
	}
	
	static void DragonCurve(int x, int y, int dir, int gener) {
		ArrayList<Integer> direction=new ArrayList<>(); // 방향을 저장할 연결리스트
		direction.add(dir); // 현재 방향 저장
		
		/*
		 * 연결리스트에 저장된 방향을 꺼내 다음 방향을 계산하여 연결리스트에 저장한다.
		 * 이러한 과정을 입력받은 세대만큼 반복한다.
		 */
		for(int i=0;i<gener;i++) 
			for(int j=direction.size()-1;j>=0;j--)
				direction.add((direction.get(j)+1)%4);
		
		/*
		 * 해당 문제는 x,y 좌표의 형태로 주어지기 떄문에
		 * 배열로 생각하기 위해서는 y와 x의 위치를 바꿔줘야 한다.  
		 */
		map[y][x]=true;
		
		/*
		 * 연결리스트에 저장된 방향들을 꺼내 시작 좌표로부터 
		 * 해당 방향으로 이동한 좌표의 배열 값을 바꿔준다.
		 */
		for(Integer d:direction) {
			x+=dx[d];
			y+=dy[d];
			
			map[y][x]=true; // 드래곤커버 표시
		}
	}
}
