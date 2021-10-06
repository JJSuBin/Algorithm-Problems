class Solution{
// 2차원 리스트 90도 회전하기
public static int[][] rotateMatrixBy90Degree(int[][] a) {
int n = a.length;
int m = a[0].length;
int[][] result = new int[n][m]; // 결과 리스트
for (int i = 0; i < n; i++) {
for (int j = 0; j < m; j++) {
result[j][n - i - 1] = a[i][j];
}
}
return result;
}
// 자물쇠의 중간 부분(실제 입력된 자물쇠 값이 들어있는 부분)이 모두 1인지 확인하는 함수
public static boolean check(int[][] newLock) {
int lockLength = newLock.length / 3;
for (int i = lockLength; i < lockLength * 2; i++) {
for (int j = lockLength; j < lockLength * 2; j++) {
if (newLock[i][j] != 1) {
return false;
}
}
}
return true;
}

public boolean solution(int[][] key, int[][] lock) {
int n = lock.length;
int m = key.length;
// 자물쇠의 크기를 기존의 3배로 변환
int[][] newLock = new int[n * 3][n * 3];
// 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
newLock[i + n][j + n] = lock[i][j];
}
}
// 0,90,180,270 각 방향에 대해서 검사
for (int rotation = 0; rotation < 4; rotation++) {
key = rotateMatrixBy90Degree(key); // 열쇠 회전
/*
* 변수 x,y를 사용한 2중 for문은 열쇠가 확장한 자물쇠 안에서 이동하기 위한 반복분이다.
* 이때 x,y의 범위는 기존 자물쇠의 크키*2 미만이다. 예를들어 기존 자물소의 크기가 3*3라면
* 확장한 자물쇠의 크기는 newLock[7][7]이 된다. 이러한 자물쇠 안에서 키 3*3이 이동하려면
* 5번만 움직이면 되기 때문에 행,열 둘다 n*2미만 까지 for문을 돌리면 된다.
*/
for (int x = 0; x < n * 2; x++) {
for (int y = 0; y < n * 2; y++) {
/*
* 변수 i,j를 사용한 2중 for문은 열쇠가 자물쇠 위에서 한번 이동했을때
* 모든 열쇠 값들을 자물쇠에 더해주기 위해 사용한 반복문이다.(홈을 메워주기 위함)
*/
for (int i = 0; i < m; i++) {
for (int j = 0; j < m; j++) {
newLock[x + i][y + j] += key[i][j];
}
}
// 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
if (check(newLock)) return true;
// 열쇠가 맞지 않는다면 다시 회전시켜 검사해야 하기 떄문에 자물쇠에서 열쇠 제거(초기화)
for (int i = 0; i < m; i++) {
for (int j = 0; j < m; j++) {
newLock[x + i][y + j] -= key[i][j];
}
}
}
}
}
return false;
}
}
