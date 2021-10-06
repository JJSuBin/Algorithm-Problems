public class level2_4 {
	public int solution(int n) {
		int answer=0;
		
		/*
		 * n이 1과 2일때는 아래 if문으로 처리해줬기 때문에
		 * n이 3일 경우에 대한 초기화
		 * f(3) = f(1)+f(2) = 1+1 이므로
		 * num1과 num2를 1로 초기화한다. 
		 */
		int num1=1;
		int num2=1;
		
		if(n==1||n==2)
			return 1;
		else {
			for(int i=3;i<=n;i++) {
				answer=(num1+num2)%1234567;
				num1=num2; // 전전수로 갱신
				num2=answer; // 전수로 갱신
			}
		}
		return answer;
    }
}
