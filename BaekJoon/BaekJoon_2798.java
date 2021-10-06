import java.util.Scanner;
/*블랙잭 게임
 *전체 카드에서 3개를 고를수 있는 모든 경우의 수를 탐색한다
 *3개의 카드의 합이 m보다 크지 않는 범위 내에서 최댓값을 찾는다.
 */
public class BaekJoon_2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int card[]=new int[n];
		
		for(int i=0;i<n;i++) card[i]=sc.nextInt();
		int result=BlackJack(card,n,m);
		System.out.println(result);
	}
	
	public static int BlackJack(int[] card,int n,int m) {
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int sum=card[i]+card[j]+card[k];
					if(sum==m) return sum;
					if(sum<m&&sum>max) max=sum;
				}
			}
		}
		return max;
	}
}
