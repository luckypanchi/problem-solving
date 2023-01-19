import sys
from collections import deque

dx = [1, 0, -1, 0, 0, 0]
dy = [0, -1, 0, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

def main():
    m, n, h = map(int, sys.stdin.readline().split())
    
    matrix = [[list(map(int, sys.stdin.readline().split())) for _ in range(n)] for _ in range(h)]
    visited = [[[0]*m for _ in range(n)] for _ in range(h)]
    que = deque()

    def bfs():
        while que:
            c, b, a = que.popleft()
            for i in range(6):
                nx = a + dx[i]
                ny = b + dy[i]
                nz = c + dz[i]
                if 0<=nx<m and 0<=ny<n and 0<=nz<h and matrix[nz][ny][nx] == 0 and visited[nz][ny][nx] == 0:
                    matrix[nz][ny][nx] = 1
                    visited[nz][ny][nx] = visited[c][b][a] + 1
                    que.append((nz, ny, nx))

    for i in range(h):
        for j in range(n):
            for k in range(m):
                if matrix[i][j][k] == 1 and visited[i][j][k] == 0:
                    que.append((i, j, k))
                    visited[i][j][k] = 1

    bfs()

    for i in matrix:
        for j in i:
            if 0 in j: 
                print(-1)
                sys.exit()

    answer = 0
    for i in visited:
        for j in i:
            tmp = max(j)
            answer = max(answer, tmp)
      
    print(answer-1)


if __name__ == "__main__":
    main()