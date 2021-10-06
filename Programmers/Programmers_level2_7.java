public class level2_7 {
	 public int solution(int n) {
	      int answer=0;
	      
	      // 완전탐색
	      for(int i=1;i<=n;i++) { // 더하기를 시작하는 숫자
	    	int sum=0;
	    	for(int j=i;j<=n;j++) {
	    		sum+=j;
	    		// 조건을 만족하는 경우의 수 +1하고 break
	    		if(sum==n) {
	    			answer++;
	    			break;
	    		}
	    		// n이 될 수 없는 경우이기 떄문에 break
	    		else if(sum>n)
	    			break;
	    	}
	      }
	      return answer;
	  }
}
