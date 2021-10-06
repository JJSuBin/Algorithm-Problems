import java.util.*;

public class BaekJoon_1018 {
	public static int n,m;
	public static int min=Integer.MAX_VALUE;
	public static boolean[][] chess;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		chess=new boolean[n][m];
		
		/*
		 * Scanner 의 경우 공백자로 구분하다가 개행으로 입력되면 스트림에 개행이 남아있어서
		 * 의도와 달리 첫 번째 String 입력은 개행이 저장된다.
		 * 그렇기 때문에 nextLine() 을 통해 문자열 입력 전의 int와 String 입력 사이의 개행을 없애주도록 한다.
		 */
		sc.nextLine();
		
		// 체스판 정보 입력 받기
		for(int i=0;i<n;i++) {
			String str=sc.nextLine();
			for(int j=0;j<m;j++) {
				// 흰색이면 배열 값을 true, 검정색이면 false로 저장
				if(str.charAt(j)=='W')
					chess[i][j]=true;
				else 
					chess[i][j]=false;
			}
		}
		
		/*
		 * 입력 받은 n*m 크기의 체스판을 8*8 크기씩 잘라 비교해야 하기 떄문에
		 * (n-8)*(m-8) 만큼 8*8 체스판이 움직이면서 이동하게 된다. 
		 * 하지만 만약 입력 받은 n,m이 8,8 이라면 0이 되기 때문에 
		 * 각 라인에에서 전체 칸이 8칸일 경우의 1을 더한 (n-7)*(m-7)이 이동 횟수가 된다.
		 */
		int n_row=n-7;
		int m_col=m-7;
		
		for(int i=0;i<n_row;i++) {
			for(int j=0;j<m_col;j++) {
				repaint(i,j);
			}
		}
		System.out.println(min);
	}
	
	public static void repaint(int x, int y) {
		/*
		 * x_end, y_end는 비교할 8*8 체스판의 끝 배열 번호를 의미한다.
		 * 시작 배열로 부터 8씩 증가한 수를 저장하고, 
		 * 이 변수를 활용하여 체스판의 처음부터 끝까지 잘라낸 체스판과 비교한다.
		 */
		int x_end=x+8;
		int y_end=y+8;
		int count=0;
		
		// 비교 시작 배열의 값을 저장하고
		boolean check=chess[x][y];
		
		// 체스판 비교를 시작한다.
		for(int i=x;i<x_end;i++) {
			for(int j=y;j<y_end;j++) {
				
				/*
				 * 각 열의 체스판은 양 옆의 체스판의 색과 달라야 하기 떄문에
				 * 첫 번째 칸의 색을 저장해둔 변수의 값을 칸이 지날때마다 
				 * 바꿔주면서 올바른 색이 아닐 경우에는 count를 증가시킨다.  
				 */
				if(chess[i][j]!=check)
					count+=1;
				
				check=(!check);
			}
			// 각 행의 처음 체스판의 색도 달라야 하기 때문에 행이 달라질 떄도 check 값을 반전시켜준다.
			check=(!check);
		}
		
		/*
		 *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의 색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
		 */
		count=Math.min(count, 64-count);
		
		// 이전까지의 경우 중 최솟값보다 현재 count 값이 더 작을 경우 최솟값을 갱신 
		min=Math.min(min, count);
	}
}
