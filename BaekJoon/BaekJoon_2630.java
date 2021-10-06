import java.util.*;

public class BaekJoon_2630 {
	public static int n,blue,white;
	public static int[][] paper;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		paper=new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				paper[i][j]=sc.nextInt();
		
		divide(0,0,n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	// 색종이의 크기를 n/2 하는 함수
	public static void divide(int row, int col, int size) {
		/*
		 * 나눈 색종이의 크기가 모두 같은 색이라면
		 * 첫 번째 색깔에 따라 색 변수 값을 증가시킨다. 
		 */
		if(check(row,col,size)) {
			if(paper[row][col]==0)
				white+=1;
			else 
				blue+=1;
			return;
		}
		
		// 색이 같지 않다면 크기를 반 줄인다.
		int newsize=size/2;
		/*
		 * 줄인 크기의 각 사분면에 대해서 
		 * 색이 모두 동일한지 확인한다. 
		 */
		divide(row,col,newsize); // 1사분면
		divide(row,col+newsize,newsize); // 2사분면
		divide(row+newsize,col,newsize); // 3사분면
		divide(row+newsize,col+newsize,newsize); // 4사분면
	}
	
	// 나눈 색종이 부분이 모두 같은 색인지 확인하는 함수
	public static boolean check(int row, int col, int size) {
		int start=paper[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(paper[i][j]!=start)
					return false;
			}
		}
		return true;
	}
}
