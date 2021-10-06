public class level1_7 {
	public int solution(int n) {
		long num = n; 
        int count = 0;
        
        while (num!=1) {
        	// 짝수인 경우
        	if (num % 2 ==0) 
                num /= 2;
            // 홀수인 경우
            else 
                num=num*3+1;
            
        	// 수행 횟수 증가
            count++;
            // 수행 횟수가 500 초과시 -1 반환
            if (count>500)
                return -1;
        }
        return count;
    }
}
