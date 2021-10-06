public class level2_13 {
	public int solution(String dirs) {
        int answer=0;
        int[] dx= {-1,0,1,0}; // 좌,아래,우,위
        int[] dy= {0,-1,0,1};
        char[] moves= {'L','D','R','U'}; // 위 배열에 맞는 움직임
        /*
         * 해당 4차원 배열은 1,2차원 지점에서 
         * 3,4차원 지점으로 이동했다는 것을 의미한다.
         */
        boolean[][][][] visited=new boolean[11][11][11][11]; 
        int x=5; // 처음 위치
        int y=5;
        int nx=5; // 이동 후 위치
		int ny=5;
		
        for(int i=0;i<dirs.length();i++) {
        	char ch=dirs.charAt(i);
        	
        	// 문자열 dirs의 문자에 맞는 좌표의 값을 더해 위치를 갱신한다.
        	for(int j=0;j<4;j++) {
        		if(moves[j]==ch) {
        			nx=x+dx[j];
        			ny=y+dy[j];
        			
        			// 범위에 벗어난 좌표라면 이전 좌표의 값을 저장후 넘어간다.
        			if(nx>10||ny>10||nx<0||ny<0) {
        				nx=x;
            			ny=y;
        				continue;
        			}
        			
        			/*
        			 * 방문하지 않은 좌표하면 방문처리를 해준다.
        			 * 
        			 * 이때 (0,0)에서 (0,1)로 이동한 것과
        			 * (0,1)에서 (0,0)으로 이동한 거리는 방문한 길이 같으므로 두 경우 모두 방문처리 해준다.
        			 */
        			if(visited[x][y][nx][ny]==false) {
        				visited[x][y][nx][ny]=true;
        				visited[nx][ny][x][y]=true;
        				answer+=1;
        			}
        		}
        		// 다음 이동을 위해 좌표 값 갱신
        		x=nx;
    			y=ny;
        	}
        }
        return answer;
    }
}
