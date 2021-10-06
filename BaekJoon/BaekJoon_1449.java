import java.util.*;

public class BaekJoon_1449 {
	// 처음 누수 지점을 무조건 테이프를 붙여야하기 떄문에 count는 1로 초기화
	public static int n,l,count=1;
	public static ArrayList<Integer> position=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		l=sc.nextInt();
		
		for(int i=0;i<n;i++)
			position.add(sc.nextInt());
		
		// 입력받은 위치를 정렬
		Collections.sort(position);
		
		int prev=position.remove(0); // 이전의 위치

		while(!position.isEmpty()) {
			int current=position.remove(0); // 현재 위치
			
			/*
			 * 두 위치의 거리 차가 하나의 테이프로 커버 가능하다면
			 * 개수를 증가시키지 않고 넘어간다.
			 * 이때 prev는 갱신시키지 않아야 한다.
			 * 
			 * 예를 들어 1 2 3 101 102 지점에서 누수가 일어났다면
			 * 1-2 지점은 if문을 만족하므로 count 하지 않지만 prev는 1이기 때문에
			 * 다름 3 지점에서는 3-1=2는 아래 if 문을 만족하지 않기 때문에 
			 * count 증가하고 prev를 갱신시켜준다.
			 */
			if(current-prev<=l-1) 
				continue;
				
			prev=current; // prev 갱신
			count++; // 테이프 수 count
		}
		System.out.println(count);
	}

}
