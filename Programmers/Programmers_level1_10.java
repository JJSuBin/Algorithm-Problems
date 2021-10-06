public class level1_10 {
	public int[] solution(int[] arr) {
		/*
		 * arr의 길이가 1이면 삭제하고 남은 값이 없기 때문에
		 * 새로운 배열을 만들어 -1을 저장하고 return 한다. 
		 */
		if(arr.length==1) {
        	int[] answer2= {-1};
        	return answer2;
        }
		
		// 배열 arr에서 가장 작은 값의 인덱스를 찾아 저장한다. 
		int minindex=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[minindex]>arr[i])
				minindex=i;
		}
		
		int[] answer=new int[arr.length-1];
		int count=0;
		/*
		 * 가장 작은 값을 제외한 나머지 arr배열의 값을
		 * answer 배열에 저장한다. 
		 */
        for(int i=0;i<arr.length;i++) {
        	if(i==minindex)
        		continue;
        	answer[count++]=arr[i];
        }
        
        return answer;
    }
}
