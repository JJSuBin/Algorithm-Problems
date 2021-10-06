import java.util.*;

public class BaekJoon_10867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		// 중복된 숫자를 제거하기 위해 HashSet을 사용
		HashSet<Integer> hs=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
			hs.add(sc.nextInt());
		
		/*
		 * HashSet에 저장된 숫자들을 정렬하기 위해서는
		 * 연결리스트에 값을 저장 후 연결리스트를 정렬하여야 한다. 
		 */
		ArrayList<Integer> num=new ArrayList<>(hs);
		Collections.sort(num);
		
		for(int i=0;i<num.size();i++)
			System.out.print(num.get(i)+" ");
	}

}
