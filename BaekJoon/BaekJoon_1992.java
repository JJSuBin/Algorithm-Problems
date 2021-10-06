import java.util.*;

public class BaekJoon_1992 {
	public static int n;
	public static int[][] tree;
	public static StringBuilder sb=new StringBuilder();
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		tree=new int[n][n];
		
		// 입력받은 문자열을 정수로 변환하여 저장
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<n;j++) {
				tree[i][j]=str.charAt(j)-'0';
			}
		}
			
		QuadTree(0,0,n);
		System.out.println(sb);
	}
 	public static void QuadTree(int row, int col, int size) {
 		/*
		 * 나눈 영상이 모두 같은 색이라면
		 * 첫 번째 색깔에 따라 결과를 저장한다.
		 */
 		if(check(row,col,size)) {
 			if(tree[row][col]==0)
 				sb.append(0);
 			else
 				sb.append(1);
 			return;
 		}
 		
 		int newsize=size/2;
 		
 		sb.append('('); // 분해하는 영상이 나올때 마다 여는 괄호로 시작해야 한다.
 		/*
		 * 분해한 영상의 각 사분면에 대해서 
		 * 색이 모두 동일한지 확인한다. 
		 */
 		QuadTree(row,col,newsize); // 1사분면
 		QuadTree(row,col+newsize,newsize); // 2사분면 
 		QuadTree(row+newsize,col,newsize); // 3사분면
		QuadTree(row+newsize,col+newsize,newsize); // 4사분면 
		
		sb.append(')'); // 해당 분해가 끝내면 닫는괄호로 끝내야 한다.
 	}
 	
 	// 해당 부분이 모두 같은 색인지 검사하는 함수
 	public static boolean check(int row, int col, int size) {
 		int start=tree[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(tree[i][j]!=start)
					return false;
			}
		}
		return true;
 	}
}
