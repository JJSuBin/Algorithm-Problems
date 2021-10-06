import java.util.*;

public class level2_15 {
	static final int Cache_Miss=5;
	static final int Cache_Hit=1;
	
	public int solution(int cacheSize, String[] cities) {
        /*
         * 캐시 사이즈가 0일 경우 모든 경우에 캐시 미스 발생
         * 해당 경우도 처리해주어야 한다. 
         */
		if(cacheSize==0)
        	return cities.length*Cache_Miss;
		
		int answer = 0;
		LinkedList<String> cache=new LinkedList<String>();
		
		for(int i=0;i<cities.length;i++) {
			String city=cities[i].toLowerCase();
			
			/*
			 * Cache Hit 경우
			 * 이미 캐시에 있던 페이지를 큐의 처음으로 가져온다
			 */
			if(cache.remove(city)) {
				cache.addFirst(city);
				answer+=Cache_Hit;
			}
			
			/*
			 * Cache Miss 경우
			 * 캐시가 가득 찬 경우에는 참조한지 가장 오래된(가장 뒤에있는) 
			 * 페이지를 삭제하고, 맨 앞에 새 페이지를 삽입
			 * 
			 * 캐시에 빈자리가 있는 경우는 맨 앞에 새 페이지를 삽입한다.
			 */
			else {
				int size=cache.size();
				
				if(size==cacheSize)
					cache.pollLast();
				
				cache.addFirst(city);
				answer+=Cache_Miss;
			}
		}
        return answer;
    }
}
