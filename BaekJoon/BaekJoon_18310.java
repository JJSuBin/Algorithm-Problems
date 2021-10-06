import java.util.*;

public class BaekJoon_18310 {
	static int n;
	static int[] house;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		house=new int[n];
		
		for(int i=0;i<n;i++)
			house[i]=sc.nextInt();
		
		Arrays.sort(house); // 정렬
		
		/*
		 * 안테나로부터 모든 집까지의 거리가 최소가 되기 위해서는
		 * 모든 집 중 중앙에 있는 집에 안테나를 설치해야 할 것이다.
		 * 
		 * 따라서, 집의 위치가 정렬된 배열의 중앙 값의 지점의 값이 정답이 된다.
		 */
		System.out.println(house[(n-1)/2]);
	}

}
