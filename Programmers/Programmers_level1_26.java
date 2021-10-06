public class level1_26 {
	public long solution(int a, int b) {
        long answer=0;
        // a와 b중 작은 수를 시작 숫자, 큰 숫자를 마지막 숫자로 저장한다. 
        int max=Math.max(a, b);
        int min=Math.min(a, b);
        
        // a와 b중 작은 숫자부터 시작해 큰 숫자까지의 누적 합을 구한다. 
        for(int i=min;i<=max;i++)
        	answer+=i;
        
        return answer;
    }
}
