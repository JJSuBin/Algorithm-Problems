public class level2_16 {
	public String solution(int n) {
		String[] number= {"4","1","2"};
        String answer = "";
        int num=n;
        
        while(num>0) {
        	int remain=num%3;
        	num/=3;
        	
        	/*
        	 * 기존 3진법의 경우 3의 배수일 경우 자리수가 증가하지만
        	 * 해당 문제는 4도 일의 자리에 올 수 있기 때문에
        	 * 3의 배수일 경우 -1을 해주어야 한다.
        	 */
        	if(remain==0)
        		num--;
        	
        	// 연산의 결과는 뒷쪽부터 붙여나간다.
        	answer=number[remain]+answer;
        }
        return answer;
    }
}
