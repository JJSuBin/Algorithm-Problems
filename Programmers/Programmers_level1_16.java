public class level1_16 {
	public int solution(int n) {
        int answer=0;
        
        /*
         * n과 나누면 나머지가 0인 값들을 n의 약수라고 한다.
         * 약수는 1~n 사이의 값들만 가능하므로 1~n 사이의 값들을 순차탐색으로 검사하여
         * 나눠 나머지가 0인 값들을 더한 누적 합을 구해준다.
         */
        for(int i=1;i<=n;i++) {
        	if(n%i==0)
        		answer+=i;
        }
        return answer;
    }
}
