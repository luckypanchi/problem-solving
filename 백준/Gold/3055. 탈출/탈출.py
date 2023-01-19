import sys
input = sys.stdin.readline
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def main():
    n, m = map(int, input().split())
    matrix = [list(input().strip()) for _ in range(n)]

    start = (0, 0)
    dest = (0, 0)
    water = []

    for i in range(n):
        for j in range(m):
            if matrix[i][j] == 'S': start = (i, j)
            if matrix[i][j] == 'D': dest = (i, j)
            if matrix[i][j] == '*': water.append((i, j))

    matrix[start[0]][start[1]] = '.'
    
    answer = 0

    visited = [[0]*m for _ in range(n)]
    visited[start[0]][start[1]] = 1

    def bfs():
        que1 = deque(water)           # 물의 큐
        que2 = deque()              # 고슴도치의 큐
        que2.append(start)
    
        while True:
            tmp1 = len(que1)
            tmp2 = len(que2)
            for _ in range(tmp1):
                y, x = que1.popleft()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0<=ny<n and 0<=nx<m and matrix[ny][nx] == '.':
                        matrix[ny][nx] = '*'
                        que1.append((ny, nx))
            
            for _ in range(tmp2):
                y, x = que2.popleft()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0<=ny<n and 0<=nx<m and (matrix[ny][nx] == '.' or matrix[ny][nx] == 'D') and visited[ny][nx] == 0:
                        visited[ny][nx] = visited[y][x] + 1
                        if (ny, nx) == dest: return visited[ny][nx] - 1
                        else: que2.append((ny, nx))

            if not que2: return "KAKTUS"

    answer = bfs()
    print(answer)

if __name__ == "__main__":
    main()