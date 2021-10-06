public class level1_5 {
	 public boolean solution(int x) {
	    int sum=0;
	    int num=x; // x값 저장 변수
	    
	    // 각 자릿수의 합 구해주기
	    while(num>0) {
	    	sum+=num%10;
	    	num=num/10;
	    }
	    
	    // 하샤드 수 인지 판별
	    if(x%sum==0)
	    	return true;
	    else 
	    	return false;
	 }
}
