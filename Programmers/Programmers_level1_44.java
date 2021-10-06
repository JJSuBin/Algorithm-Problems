import java.util.*;

public class level1_44 {
	public String solution(String[] participant, String[] completion) {
        // 두 배열을 사전 순으로 정렬한다.
		Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 사전순으로 정렬된 배열 값들 중 같은 값을 갖지 않는 배열 값 return
        for(int i=0;i<completion.length;i++)
        	if(!participant[i].equals(completion[i]))
        		return participant[i];
        
        // completion 배열의 끝까지 모든 값이 같다면 participant 배열의 마지막 값을 return
        return participant[participant.length-1];
    }
}
