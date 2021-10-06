import java.util.*;

class Virus_18405 implements Comparable<Virus_18405>{
	int number;
	int sec;
	int x;
	int y;
	
	public Virus_18405(int number, int sec, int x, int y) {
		this.number=number;
		this.sec=sec;
		this.x=x;
		this.y=y;
	}

	@Override
	public int compareTo(Virus_18405 o) {
		// 바이러스의 번호가 작은 순서대로 정렬 
		return this.number-o.number;
	}
}	

public class BaekJoon_18405 {
	public static int n,k;
	public static int[][] map;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static ArrayList<Virus_18405> viruses = new ArrayList<Virus_18405>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		map=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				
				// 입력받은 값이 바이러슬면 연결리스트에 저장
				if(map[i][j]!=0)
					viruses.add(new Virus_18405(map[i][j],0,i,j));
			}
		}
		
		/*
		 * 번호가 작은 바이러스가 먼저 퍼져야하기 때문에
		 * 바이러스가 저장되어 있는 연결리스트를 저장한다.
		 */
		Collections.sort(viruses); 
		
		/*
		 * 바이러스의 번호가 작은 순서대로 정렬되어 있는 연결리스의 값을
		 * 큐에 옮긴다. 즉, 큐에는 바이러스 번호, 전파된 시간, 바이러스가 있는 배열의 인덱스가 저장되어 있다. 
		 */
		Queue<Virus_18405> q=new LinkedList<Virus_18405>();
		for(int i=0;i<viruses.size();i++)
			q.offer(viruses.get(i));

		int s=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		// BFS 수행
		while(!q.isEmpty()) {
			Virus_18405 virus=q.poll();
			
			// 다음 바이러스의 전파 시간이 s와 같다면 종료
			if(virus.sec==s)
				break;
			
			// 상,하,좌,우 바이러스 전파
			for(int i=0;i<4;i++) {
				int nx=virus.x+dx[i];
				int ny=virus.y+dy[i];
				
				// 이동한 인덱스가 범위 내에 있고, 바이러스가 없는 곳이라면
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(map[nx][ny]==0) {
						map[nx][ny]=virus.number; // 해당 바이러스 전파
						q.offer(new Virus_18405(virus.number,virus.sec+1,nx,ny)); // 전파 시간을 1 늘린 값을 큐에 삽입
					}
				}
			}
		}
		
		// s초 동안 전파가 끝난다면 해당 배열 값 출력
		System.out.println(map[x-1][y-1]);
	}
}
