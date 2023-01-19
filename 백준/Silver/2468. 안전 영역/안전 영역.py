import sys
input = sys.stdin.readline

n = int(input())
mat = []
for i in range(n):
    mat.append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(sy, sx, visited, cnt, wh):
    visited[sy][sx] = 1
    q = []
    q.append([sy, sx])
    while q:
        y, x = q.pop(0)
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= nx < n and 0 <= ny < n and visited[ny][nx] == 0 and mat[ny][nx] > wh:
                visited[ny][nx] = cnt
                q.append([ny, nx])
ans = 1
wh = 1
while True:
    cnt = 1
    visited = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 and mat[i][j] > wh:
                bfs(i, j, visited, cnt, wh)
                cnt += 1
    if cnt - 1 == 0:
        break
    ans = max(ans, cnt - 1)
    wh += 1
print(ans)