import java.util.*;

public class BaekJoon_1780 {
	public static int n,minus,zero,plus;
	public static int[][] matrix;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		matrix=new int[n][n];
		
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				matrix[i][j]=sc.nextInt();
				
		MakeMatrix(0,0,n);	
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	
	public static void MakeMatrix(int row, int col, int size) {
		/*
		 * 분할한 부분이 같은 숫자로만 이루어져 있다면
		 * 해당 숫자 변수를 증가시킨다. 
		 */
		if(check(row,col,size)) {
			if(matrix[row][col]==-1)
				minus++;
			else if(matrix[row][col]==0)
				zero++;
			else
				plus++;
			
			return;
		}
		
		// 각 부분을 9 부분으로 나누어 검사한다. 
		int newsize=size/3;
		
		
		MakeMatrix(row,col,newsize); // 1번 부분
		MakeMatrix(row,col+newsize,newsize); // 2번 부분
		MakeMatrix(row,col+newsize*2,newsize); // 3번 부분
		
		MakeMatrix(row+newsize,col,newsize); // 4번 부분
		MakeMatrix(row+newsize,col+newsize,newsize); // 5번 부분
 		MakeMatrix(row+newsize,col+newsize*2,newsize); // 6번 부분
		
		MakeMatrix(row+newsize*2,col,newsize); // 7번 부분
		MakeMatrix(row+newsize*2,col+newsize,newsize); // 8번 부분
		MakeMatrix(row+newsize*2,col+newsize*2,newsize); // 9번 부분
	}
	
	// 해당 부분이 모두 같은 숫자인지 검사하는 함수
	public static boolean check(int row, int col, int size) {
		int start=matrix[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(matrix[i][j]!=start)
					return false;
			}
		}
		return true;
	}
}
