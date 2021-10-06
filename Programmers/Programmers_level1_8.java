public class level1_8 {
	public int[] solution(int n, int m) {
        int[] answer=new int[2];
        int a=m;
        int b=n;
        
        /*
         * 유클리드 호제법을 사용하여 최대공약수 구하기
         * GCD(a,b) = GCD(b,r) 이때 r은 a%b를 의미한다.
         */
        while(b!=0) {
        	int r=a%b;
        	
        	a=b;
        	b=r;
        }
        
        answer[0]=a; // 최대공약수 저장
        answer[1]=(n/a)*(m/a)*a; // 최소공배수 구하기
        
        return answer;
    }
}
