import java.util.*;

public class BaekJoon_17779 {
	static int[][] map;
	static int n,total=0,min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=sc.nextInt();
				total+=map[i][j];
			}
		}
		
		// x,y,d1,d2 나올 수 있는 모든 경우의 수 탐색
		for(int x=1;x<=n;x++) {
			for(int y=1;y<=n;y++) {
				for(int d1=1;d1<=n;d1++) {
					for(int d2=1;d2<=n;d2++) {
						// (x+d1+d2 ≤ N)를 벗어난 경우
						if(x+d1+d2>n)
							continue;
						
						// (1 ≤ y-d1), (y+d2 ≤ N)를 벗어난 경우
						if(y-d1<=0||y+d2>n)
							continue;
						
						seperateDistric(x,y,d1,d2);
					}
				}
			}
		}
		
		System.out.println(min);
	}
	static void seperateDistric(int x, int y, int d1, int d2) {
		boolean[][] check=new boolean[n+1][n+1];
		
		/*
		 * 5구역 체크하기 
		 * 
		 * 1. (x, y), (x+1, y-1), ..., (x+d1, y-d1)
		 * 4. (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		 */
		for(int i=0;i<=d1;i++) {
			check[x+i][y-i]=true;
			check[x+d2+i][y+d2-i]=true;
		}
		
		/*
		 * 5구역 체크하기 
		 * 
		 * 2. (x, y), (x+1, y+1), ..., (x+d2, y+d2)
		 * 3. (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		 */
		for(int i=0;i<=d2;i++) {
			check[x+i][y+i]=true;
			check[x+d1+i][y-d1+i]=true;
		}
		
		int[] people=new int[6]; // 각 구역의 인구수를 저장할 배열
		
		// 1구역의 인구 수 구하기 : 1 ≤ r < x+d1, 1 ≤ c ≤ y
		for(int i=1;i<x+d1;i++) {
			for(int j=1;j<=y;j++) {
				if(check[i][j])
					break;
				
				people[1]+=map[i][j];
			}
		}
		
		// 2구역의 인구 수 구하기 : 1 ≤ r ≤ x+d2, y < c ≤ N
		for(int i=1;i<=x+d2;i++) {
			for(int j=n;j>y;j--) {
				if(check[i][j])
					break;
				
				people[2]+=map[i][j];
			}
		}
		
		// 3구역의 인구 수 구하기 : x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		for(int i=x+d1;i<=n;i++) {
			for(int j=1;j<y-d1+d2;j++) {
				if(check[i][j])
					break;
				
				people[3]+=map[i][j];
			}
		}
		
		// 4구역의 인구 수 구하기 : x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		for(int i=x+d2+1;i<=n;i++) {
			for(int j=n;j>=y-d1+d2;j--) {
				if(check[i][j])
					break;
				
				people[4]+=map[i][j];
			}
		}
		
		// 5구역의 인구수는 전체 인구수에서 다른 구역의 인구수를 빼는 방법으로 구한다.
		people[5]=total;
		
		for(int i=1;i<=4;i++)
			people[5]-=people[i];
		
		/*
		 * 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값을 구하기 위해
		 * people 배열을 정렬후 배열의 마지막 값에서 첫 번째 값을 뺀 값과 min을 비교하여 갱신한다. 
		 */
		Arrays.sort(people); 
		min=Math.min(min, people[5]-people[1]);
	}
}
