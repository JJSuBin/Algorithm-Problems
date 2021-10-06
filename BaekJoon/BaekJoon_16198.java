import java.util.*;

public class BaekJoon_16198 {
	static ArrayList<Integer> energy=new ArrayList<>();
	static int n,max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=0;i<n;i++)
			energy.add(sc.nextInt());
		
		dfs(0);
		System.out.println(max);
		
	}
	static void dfs(int sum) {
		// 첫 번째와 마지막 에너지 구슬만 남게 된다면 최댓값 갱신
		if(energy.size()==2) {
			max=Math.max(max, sum);
			return;
		}
		
		// 첫 번째와 마지막 에너지 구슬은 선택할 수 없기 때문에 그 사이의 인덱스만 선택
		for(int i=1;i<energy.size()-1;i++) {
			int temp=energy.get(i); 
			int cal=energy.get(i-1)*energy.get(i+1); // 모인 에너지 계산
			energy.remove(i); // i번째 에너지 구슬 제거
			dfs(sum+cal); // 모인 에너지만큼 누적한 뒤 재귀호출
			energy.add(i, temp); // 다음 경우의 수를 위해 제거한 위치에 다시 삽입
		}
	}
}
