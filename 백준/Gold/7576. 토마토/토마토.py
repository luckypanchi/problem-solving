import sys
input = sys.stdin.readline
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def main():
    m, n = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    visited = [[0]*m for _ in range(n)]


    start = []
    for i in range(n):
        for j in range(m):
            if matrix[i][j] == 1: start.append((i, j))
            if matrix[i][j] == -1: visited[i][j] = -1

    def bfs():

        que = deque()
        
        for arr in start:
            que.append(arr)
        
        for arr in start:
            y, x = arr
            visited[y][x] = 1

        while que:
            y, x = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0<=nx<m and 0<=ny<n and visited[ny][nx] == 0 and matrix[ny][nx] == 0:
                    que.append((ny, nx))
                    visited[ny][nx] = visited[y][x] + 1

        return visited

    result = bfs()
    answer = 0
    stop = False

    for i in range(n):
        for j in range(m):
            if result[i][j] == 0:
                answer = -1
                stop = True
                break
            else:
                answer = max(answer, result[i][j] - 1)
        if stop: break

    print(answer)
    
if __name__ == "__main__":
    main()