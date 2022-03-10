import java.util.* ;

public class 테트로미노_14500 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int[][] e_dx= {{1,1,1,0},{0,0,0,1},{0,1,2,1},{0,1,2,1}};
	static int[][] e_dy= {{0,1,2,1},{0,1,2,1},{0,0,0,1},{1,1,1,0}};
	static int n,m,max=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		visited=new boolean[n][m];
		map=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visited[i][j]=true;
				puzzle1(i,j,0,0);
				visited[i][j]=false;
				
				puzzle2(i,j);
			}
		}
		System.out.println(max);
	}
	
	static void puzzle1(int x, int y, int depth, int sum) {
		if(depth==4) {
			max=Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny])
				continue;
			
			visited[nx][ny]=true;
			puzzle1(nx,ny,depth+1,sum+map[nx][ny]);
			visited[nx][ny]=false;
		}
	}
	
	static void puzzle2(int x, int y) {
		for(int i=0;i<4;i++) {
			int result=0;
			for(int j=0;j<4;j++) {
				int nx=x+e_dx[i][j];
				int ny=y+e_dy[i][j];
				
				if(nx<0||ny<0||nx>=n||ny>=m) 
					continue;
				
				result+=map[nx][ny];
			}
			
			max=Math.max(max, result);
		}
	}
}
