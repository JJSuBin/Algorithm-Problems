public class level1_20 {
	public int solution(int n) {
        int answer=0;
        boolean[] sosu=new boolean[n+1];
        sosu[0]=sosu[1]=true; // 0과 1은 소수가 아니기 때문에 true 처리
        
        /* 
         * <에라토스테네스 알고리즘>
         * 2부터 루트n 이하까지 반복하여
         * 자연수중에서 k를 제외한 k의 배수들을 제외시켜가며 소수를 구하는 알고리즘
         */
        for(int i=2;i<=n;i++) {
        	if(sosu[i]==true)
        		continue;
        	for(int j=i+i;j<=n;j=j+i)
        		sosu[j]=true;
        }
        
        /* 
         * boolean 배열의 값이 false인 인덱스 값은 소수이기 때문에 
         * false 값을 가지는 배열의 갯수 카운트
         */
        for(int i=2;i<=n;i++)
        	if(sosu[i]==false)
        		answer+=1;
        
        return answer;
    }
}
