import java.util.*;

public class BaekJoon_5597 {
	static boolean[] task=new boolean[31];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<28;i++) {
			int num=sc.nextInt();
			
			// 과제를 제출한 번호는 true 처리
			task[num]=true;
		}
		
		for(int i=1;i<=30;i++) {
			// 과제를 안낸 사람의 번호 저장
			if(task[i]==false) {
				sb.append(i+" ");
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}

}
