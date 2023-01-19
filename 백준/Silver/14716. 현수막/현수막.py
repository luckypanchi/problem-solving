import sys
input = sys.stdin.readline
from collections import deque

dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

def main():
    m, n = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(m)]

    def bfs(p):
        que = deque()
        que.append(p)
        while que:
            y, x = que.popleft()
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0<=nx<n and 0<=ny<m and matrix[ny][nx] == 1:
                    matrix[ny][nx] = -1
                    que.append((ny, nx))

    answer = 0

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == 1:   
                bfs((i, j))
                answer += 1

    print(answer)


if __name__ == "__main__":
    main()