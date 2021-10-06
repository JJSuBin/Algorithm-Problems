public class level1_40 {
	 public int solution(int[] nums) {
	        int answer=0;
	        
	        // nums에 있는 값들 중 서로 다른 3개의 합이 소수인지 판별
	        for(int i=0;i<nums.length;i++) {
	        	for(int j=i+1;j<nums.length;j++) {
	        		for(int k=j+1;k<nums.length;k++) {
	        			int num=nums[i]+nums[j]+nums[k];
	        			// 소수라면 answer 값 증가
	        			if(findprime(num)==true)
	        				answer+=1;
	        		}
	        	}
	        }
	        return answer;
	 }
	 
	 /*
	  * 소수 판별 함수
	  * 2~n-1 사이의 숫자 중 n과 나눠 떨어지는 숫자가 있다면
	  * n은 소수가 아니다. 
	  */
	 public boolean findprime(int n) {
		for(int i=2;i<n;i++)
			if(n%i==0)
				return false;
		 return true;
	 }
}
