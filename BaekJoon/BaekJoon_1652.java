import java.util.*;

public class BaekJoon_1652 {
	public static int[][] map=new int[101][101];
	public static int n,row_count=0,col_count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		// 맵 상태 저장
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<n;j++) {
				map[i][j]=str.charAt(j);
			}
			// 처음 벽, 끝의 벽도 짐으로 간주한다.
			map[i][n]=map[n][i]='X';
		}
		
		// 연속해서 두 칸이 비어있고, 그 다음이 벽일 경우 누울수 있는 자리
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// 가로로 누울 수 있는 경우
				if(map[i][j]=='.'&&map[i][j+1]=='.'&&map[i][j+2]=='X') 
					row_count++;
				// 세로로 누울 수 있는 경우
				if(map[j][i]=='.'&&map[j+1][i]=='.'&&map[j+2][i]=='X') 
					col_count++;
			}
		}
		System.out.println(row_count+" "+col_count);
	}

}
