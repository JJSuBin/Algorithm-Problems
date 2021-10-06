import java.util.*;

public class BaekJoon_10830 {
	public static int n;
	public static int[][] matrix;
	public static final int mod=1000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		long b=sc.nextLong();
		matrix=new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				/*
				 * B=1 일 때는 pow 과정에서 바로 A가 반환 될 수 있다.
				 * 이 때의 경우 만약 원소가 1000이상일 경우 pow 메소드에서 모듈러연산이
				 * 실행되지 않기 때문에 오답이 되어버린다.
				 * 
				 * 이를 방지하기 위해 초기 행렬에도 1000으로 나눈 나머지 값으로
				 * 초기화를 해준다.
				 */
				matrix[i][j]=sc.nextInt()%mod;
		
		StringBuilder sb = new StringBuilder();
		
		int[][] result=pow(matrix,b);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	// 행렬 제곱 분할정복
	public static int[][] pow(int[][] o1, long exp) {
		// 지수가 1일 때는 o1 return
		if(exp==1L)
			return o1;
		
		// 지수를 절반으로 분할하여 재귀호출
		int[][] result=pow(o1,exp/2);
		
		// 재귀에서 얻은 행렬을 제곱해준다.
		result=multiply(result,result);
		
		// 지수가 홀수인 경우에는 마지막에 입력 받은 원래의 행렬을 곱해준다.
		if(exp%2==1L)
			result=multiply(result,matrix);
		
		return result;
	}
	
	// 행렬 곱셈 함수
	public static int[][] multiply(int[][] o1,int [][]o2) {
		int[][] result=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					result[i][j]+=o1[i][k]*o2[k][j];
					// 행렬 연산이 끝나면 나머지 연산 수행
					result[i][j]%=mod;
				}
			}
		}
		return result;
	}
}
