import java.util.*;

public class BaekJoon_2740 {
	public static int a[][],b[][],result[][];
	public static int n,m,k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		// n X m 크기 a행렬 
		n=sc.nextInt();
		m=sc.nextInt();
		a=new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				a[i][j]=sc.nextInt();

		// m X k 크기 b행렬
		m=sc.nextInt();
		k=sc.nextInt();
		b=new int[m][k];
		
		for(int i=0;i<m;i++)
			for(int j=0;j<k;j++)
				b[i][j]=sc.nextInt();
		
		// 결과를 저장할 행렬의 크기는 n X k
		result=new int[n][k];
		// 행렬 계산	
		for(int i=0;i<n;i++) { // i : a행렬의 row
			for(int j=0;j<k;j++) { // j : b행렬의 col
				
				// a행렬의 row와 b행렬의 col의 각 값들을 곱한 뒤 더한다.
				for(int k=0;k<m;k++) { // 더해주는 원소의 개수는 k개
					
					/* A행렬의 i번째 row의 k번째 열 원소와, B
					 * 의 j번째 col의 k번째 행 원소를 곱한 뒤 누적합을 결과 행렬의 저장
					 */
					result[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		
		// 결과 행렬 출력
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++)
				System.out.print(result[i][j]+" ");
			System.out.println();
		}
	}
}
