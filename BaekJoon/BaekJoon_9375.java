import java.util.*;

public class BaekJoon_9375 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			// <종류, 개수>를 저장할 해시맵
			HashMap<String,Integer> hm=new HashMap<>();
			
			int n=sc.nextInt();
			
			while(n-->0) {
				sc.next(); // 의상 이름은 저장할 필요가 없음
				String kind=sc.next(); // 의상 종류 
				
				/*
				 * 해당 종류의 의상이 해시맵에 있을 경우 
				 * 해시맵에 저장되어 있던 해당 종류의 개수를 1 증가시킨다.
				 */
				if(hm.containsKey(kind)) 
					hm.put(kind, hm.get(kind)+1);
				/*
				 * 해당 종류의 의상이 해시맵에 없는 경우에는 
				 * 해당종류를 만들고 1로 초기화 한다. 
				 */
				else 
					hm.put(kind, 1);
			}
			
			int result=1;
			/*
			 * 안 입는 경우를 고려하여 각 종류별의 의상에 1 증가시켜 준 값을
			 * 결과 값에 곱해줘야 한다. 
			 * 
			 * 예를 들어, 
			 * [headgear] : hat, turban, NULL( / [eyewear] : sunglasses, NULL 인 경우는
			 * 3C1 * 2C1 = 3*2가 되기 때문에 각 종류별의 의상의 개수를 곱해준 값이 결과 값이 된다.
			 */
			for(int val:hm.values())
				result*=(val+1);
			
			/*
			 *  이때 모두 null 값이 선택되어 
			 *  아무것도 입지 않은 경우는 빼줘야 하기 때문에 -1한 값이 결과 값이 된다.
			 */
			System.out.println(result-1);
		}
	}
}
