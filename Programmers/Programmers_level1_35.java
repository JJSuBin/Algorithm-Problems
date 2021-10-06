public class level1_35 {
	public int solution(int left, int right) {
        int answer=0;
        
        for(int i=left;i<=right;i++) {
        	// 약수의 개수가 짝수일때는 더하기
        	if(count(i)%2==0)
        		answer+=i;
        	// 약수의 개수가 홀수일때는 더하기
        	else
        		answer-=i;
        }
        
        return answer;
    }
	
	// 약수의 개수 구하는 함수
	public int count(int n) {
		int result=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0)
				result++;
		}
		return result;
	}
}
