public class level1_46 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer=new String[n];
        
		/*
		 * 두 개의 비밀지도 각 줄마다 10진수의 값을 2진수로 변환 후
		 * 두 2진수의 각 자리를 비교하여 공백 또는 #을 저장한다.
		 * 이러한 과정을 주어진 비밀지도의 길이인 n만큼 반복한다.  
		 */
        for(int i=0;i<n;i++) {
        	// 각 배열의 10진수 값을 2진수로 변환한다.
        	int[] arr1Binary=makeBinary(n,arr1[i]);
            int[] arr2Binary=makeBinary(n,arr2[i]);
            String str="";
            
            /* 
             * 2진수로 변환한 자릿수의 값이 모두 0일 경우에만 공백 저장
             * 둘 중 하나의 값이라도 1일 경우에는 '#' 저장
             */
            for(int j=0;j<arr1Binary.length;j++) {
            	if(arr1Binary[j]==0&&arr2Binary[j]==0) {
            		str+=" ";
            	}
            		
            	else 
            		str+="#";
            }
            // 한 줄이 처리가 끝나면 결과 값 answer 배열에 저장
            answer[i]=str;
        }
        return answer;
    }
	
	// 10진수를 2진수로 변환하는 함수
	public int[] makeBinary(int n,int num) {
		int[] result=new int[n];
		int number=num;
		
		for(int i=n-1;i>=0;i--) {
			result[i]=number%2;
			number/=2;
		}
		return result;
	}
}
