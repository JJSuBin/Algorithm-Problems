import java.util.*;

class Subject_10825 implements Comparable<Subject_10825>{
	String name;
	int language;
	int english;
	int mathematic;
	
	public Subject_10825(String name, int language, int english, int mathematic) {
		this.name=name;
		this.language=language;
		this.english=english;
		this.mathematic=mathematic;
	}
	
	@Override
	public int compareTo(Subject_10825 o) {
		if(this.language==o.language) {
			if(this.english==o.english) {
				if(this.mathematic==o.mathematic) {
					// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서대로 정ㄹ려
					return this.name.compareTo(o.name);
				}
				// 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서대로 정렬
				return o.mathematic-this.mathematic; 
			}
			// 국어 점수가 같다면 영어 점수가 증가하는 순서대로 정렬
			return this.english-o.english;
		}
		
		// 국어 점수가 감소하는 순서대로 정렬
		return o.language-this.language;
	}
}

public class BaekJoon_10825 {
	static int n;
	static ArrayList<Subject_10825> arr=new ArrayList<Subject_10825>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String name=sc.next();
			int lan=sc.nextInt();
			int eng=sc.nextInt();
			int math=sc.nextInt();
			
			arr.add(new Subject_10825(name,lan,eng,math));
		}
		
		Collections.sort(arr); // 정렬
		
		// 정렬된 결과에서 이름만 출력
		for(int i=0;i<n;i++)
			System.out.println(arr.get(i).name);
	}

}
