import sys
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def main():
    m, n = map(int, sys.stdin.readline().split())
    matrix = [list(map(lambda x: ord(x)-65, sys.stdin.readline().strip())) for _ in range(m)]

    def dfs(start, tmp):        
        nonlocal answer
        y, x = start
        answer = max(answer, tmp)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m and visited[matrix[ny][nx]] == 0:
                visited[matrix[ny][nx]] = 1
                dfs((ny, nx), tmp+1)
                visited[matrix[ny][nx]] = 0

    answer = 1
    visited = [0]*26
    visited[matrix[0][0]] = 1
    dfs((0,0), answer)

    print(answer)




if __name__ == "__main__":
    main()