import java.util.Scanner;

public class BeakJoon_7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] people=new int[n][2];
		int[] result=new int[n];
		
		// 각각 키, 몸무게 입력 받음
		for(int i=0;i<n;i++) {
			people[i][0]=sc.nextInt();
			people[i][1]=sc.nextInt();
		}
		
		// 처음에는 모두 1등으로 설정
		for(int i=0;i<n;i++)
			result[i]=1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// 같은 사람인 경우 비교하지 않음
				if(i==j) continue;
				
				// 다른 사람보다 키, 몸무게가 모두 작을 경우에만 순위에서 밀려남
				if(people[i][0]<people[j][0]&&people[i][1]<people[j][1])
					result[i]+=1;
			}
		}
		
		// 순위 출력
		for(int i=0;i<n;i++)
			System.out.print(result[i]+" ");
	}
}
