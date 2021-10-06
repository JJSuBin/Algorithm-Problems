public class level2_18 {
	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // 처음의 시작하는 수가 +인 경우와 -인 경우 가능한 식의 합을 저장한다.
        answer=dfs(numbers,target,1,numbers[0])+dfs(numbers,target,1,-numbers[0]);
        
        return answer;
    }
	
	public static int dfs(int[] numbers, int target, int depth, int num) {
		// 모든 숫자를 더한 값이 target과 같다면 1 return, 같지 않다면 0 return
		if(depth==numbers.length) {
			if(num==target)
				return 1;
			else 
				return 0;
		}
		
		// 덧셈 식을 했을 경우와 뺄셈 식을 했을 경우 가능한 식의 개수를 result에 누적한다.
		int result=0;
		result+=dfs(numbers,target,depth+1,num+numbers[depth]);
		result+=dfs(numbers,target,depth+1,num-numbers[depth]);
		
		return result;
	}
}
