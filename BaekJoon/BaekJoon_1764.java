import java.util.*;

public class BaekJoon_1764 {
	public static HashSet<String> hs=new HashSet<>();
	public static ArrayList<String> result=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		// 듣도 못한 사람 HashSet에 저장
		for(int i=0;i<n;i++)
			hs.add(sc.next());
		
		// 보도 못한 사람 중 듣도 못한 사람과 같은 있다면 연결리스트에 저장
		for(int i=0;i<m;i++) {
			String str=sc.next();
			if(hs.contains(str))
				result.add(str);
		}
		
		Collections.sort(result); // 정렬
		
		System.out.println(result.size()); // 듣도 보도 못한 사람 수 출력
		// 듣도 보도 못한 사람 이름 출력
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
	}

}
