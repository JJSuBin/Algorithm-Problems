import java.util.*;

public class BaekJoon_11047 {
	public static int n,k,result=0;
	public static Integer[] coin;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		coin=new Integer[n];
				
		for(int i=0;i<n;i++)
			coin[i]=sc.nextInt();
		
		// 화폐 단위가 큰 것 부터 검사하기 위해 내림차순 정렬
		Arrays.sort(coin,Collections.reverseOrder());
				
		for(int i=0;i<n;i++) {
			// 현재 동전이 k보다 작거나 같은 경우
			if(coin[i]<=k) {
				// 현재 동전으로 구성할 수 있는 개수를 더해준다.
				result+=k/coin[i];
				// k값 조정
				k=k%coin[i];
			}
		}
		System.out.println(result);
	}
}
