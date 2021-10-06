import java.util.*;

class Student_1713 implements Comparable<Student_1713>{
	int number,total,time;
	
	public Student_1713(int number,int total,int time) {
		this.number=number;
		this.total=total;
		this.time=time;
	}
	
	/*
	 * 해당 클래스를 저장하는 연결리스트를 정렬하면 
	 * 총 추천 횟수가 가장 작으면서 동시에 등록된 시간도 작은 클래스가 연결리스트의 가장 앞에 오게 된다. 
	 * 즉, 오름차순으로 정렬된다. 
	 */
	@Override
	public int compareTo(Student_1713 o) {
		// 총 추천 횟수가 같다면 등록된 시간을 기준으로 정렬
		if(this.total==o.total)
			return this.time-o.time;
		
		// 총 추천 횟수를 기준으로 정렬 
		return this.total-o.total;
	}
	
}
public class BaekJoon_1713 {
	static int n,m;
	static int[] student=new int[101]; // 각 학생의 총 추천 횟수를 저장하는 배열
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		ArrayList<Student_1713> list=new ArrayList<>(); // 액자가 걸린 학생들의 정보를 저장하는 연결리스트
		
		for(int i=0;i<m;i++) {
			int recommand=sc.nextInt(); // 추천하고자 하는 학생의 번호
			/*
			 * 추천한 학생의 추천 횟수가 0이 아니라면 이미 액자에 걸려있는 경우
			 * 액자에서 삭제되는 순간 추천 횟수도 0으로 초기화 되기 때문
			 */
			if(student[recommand]>0) {
				student[recommand]+=1; // 추천 횟수 추가
				for(int j=0;j<list.size();j++) {
					// 리스트에 추천된 학생의 번호를 찾아 총 추천 횟수 1 증가
					if(list.get(j).number==recommand) {
						list.get(j).total+=1;
						break;
					}
				}
			}
			// 추천한 학생이 액자에 걸려있지 않은 경우
			else {
				// 액자가 이미 다 차있는 경우 추천횟수가 가장 적은 학생 삭제후 추천 학생 삽입
				if(list.size()>=n) {
					Collections.sort(list); // 정렬
					int remove=list.get(0).number;  // 추천횟수가 가장 적은 학생 번호
					student[remove]=0; // 해당 학생의 총 추천 횟수 초기화
					list.remove(0); // 리스트에서 삭제
				}
				// 추천 받은 학생의 번호, 추천횟수 1, 추천 받은 시간 i 삽입
				list.add(new Student_1713(recommand,1,i)); 
				student[recommand]=1;
			}
		}
		
		// 추천 횟수가 0이 아닌 사람이 최종 후보
		for(int i=0;i<101;i++) {
			if(student[i]!=0)
				System.out.print(i+" ");
		}
	}

}
