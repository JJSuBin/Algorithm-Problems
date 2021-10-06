import java.util.*;

/*
 * 만약, 입력 받은 수가 리스트의 마지막 수 보다 크면 삽입한다.
 * 반면에 입력 받은 수가 리스트의 마지막 수 보다 작다면
 * 리스트를 오름차순으로 생각하고 이분 탐색으로 입력 받은 수가 들어갈 자리를 찾는다.
 * 찾은 자리에는 삽입이 아닌 기존의 값을 변경한다.
 */
public class BaekJoon_12015 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> list=new ArrayList<>();
		list.add(0); // 첫 번째 입력받은 수와 비교할 수 있도록 0을 미리 삽입한다.
		
		for(int i=0;i<n;i++) {
			int val=sc.nextInt();
			
			// 입력 받은 수가 리스트의 마지막 수 보다 크다면 리스트에 삽입
			if(val>list.get(list.size()-1))
				list.add(val);
			
			// 입력 받은 수가 리스트의 마지막 수 보다 작다면 이분 탐색으로 위치 탐색
			else {
				int start=1;
				int end=list.size()-1;
				while(start<end) {
					int mid=(start+end)/2;
					if(list.get(mid)>=val)
						end=mid;
					else 
						start=mid+1;
				}
                list.set(end, val);
			}
		}
		// 처음 비교를 위해 삽입한 0을 빼준 값을 출력
		System.out.println(list.size()-1);
	}
}
